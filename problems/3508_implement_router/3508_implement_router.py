from collections import deque, defaultdict
import bisect

class Router:
    def __init__(self, memoryLimit: int):
        self.memory_limit = memoryLimit
        self.queue = deque()  # stores tuples (source, destination, timestamp)
        self.seen = set()     # set of tuples to avoid duplicates
        self.dest_timestamps = defaultdict(list)   # destination -> list of timestamps (sorted by append)
        self.processed_index = defaultdict(int)    # destination -> number of timestamps popped/forwarded

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        key = (source, destination, timestamp)
        if key in self.seen:
            return False
        if len(self.queue) == self.memory_limit:
            self.forwardPacket()  # free one slot (problem requires this)
        self.queue.append(key)
        self.seen.add(key)
        self.dest_timestamps[destination].append(timestamp)
        return True

    def forwardPacket(self) -> list:
        if not self.queue:
            return []
        source, destination, timestamp = self.queue.popleft()
        self.seen.remove((source, destination, timestamp))
        # mark that destination lost one earliest timestamp
        self.processed_index[destination] += 1
        return [source, destination, timestamp]

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        lst = self.dest_timestamps.get(destination)
        if not lst:
            return 0
        left = self.processed_index.get(destination, 0)
        # use bisect with lo=left to ignore already forwarded timestamps
        lo = bisect.bisect_left(lst, startTime, lo=left)
        hi = bisect.bisect_right(lst, endTime, lo=left)
        return hi - lo
