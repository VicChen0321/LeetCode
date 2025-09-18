class TaskManager:
    def __init__(self, tasks):
        self.d = {}  # taskId -> (userId, priority)
        self.pq = [] # heap: ( -priority, -taskId, userId )

        for userId, taskId, priority in tasks:
            self.add(userId, taskId, priority)

    def add(self, userId, taskId, priority):
        self.d[taskId] = (userId, priority)
        heapq.heappush(self.pq, (-priority, -taskId, userId))

    def edit(self, taskId, newPriority):
        if taskId in self.d:
            userId, _ = self.d[taskId]
            self.d[taskId] = (userId, newPriority)
            heapq.heappush(self.pq, (-newPriority, -taskId, userId))
            # 舊的 entry 不刪，等 execTop 時跳過

    def rmv(self, taskId):
        if taskId in self.d:
            self.d.pop(taskId)
            # 舊的 entry 還在 pq，不影響，會在 execTop 跳過

    def execTop(self):
        while self.pq:
            priority, negTaskId, userId = heapq.heappop(self.pq)
            taskId = -negTaskId
            if taskId in self.d and self.d[taskId] == (userId, -priority):
                self.d.pop(taskId)
                return userId
            # 否則這是過期的，跳過
        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()