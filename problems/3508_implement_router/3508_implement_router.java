class Router {

    private final int memoryLimit;
    private final Deque<Packet> queue;
    private final Set<Packet> seen;
    private final Map<Integer, List<Integer>> destTimestamps;
    private final Map<Integer, Integer> processedIndex;


    public Router(int memoryLimit) {
                this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.processedIndex = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (seen.contains(p)) return false;
        if (queue.size() == memoryLimit) {
            forwardPacket();
        }
        queue.addLast(p);
        seen.add(p);
        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        Packet p = queue.removeFirst();
        seen.remove(p);
        processedIndex.put(p.destination, processedIndex.getOrDefault(p.destination, 0) + 1);
        return new int[]{p.source, p.destination, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> lst = destTimestamps.get(destination);
        if (lst == null) return 0;
        int left = processedIndex.getOrDefault(destination, 0);
        int lo = lowerBound(lst, left, startTime);
        int hi = upperBound(lst, lo, endTime);
        return hi - lo;
    }

    private int lowerBound(List<Integer> a, int lo, int target) {
        int l = lo, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }
    private int upperBound(List<Integer> a, int lo, int target) {
        int l = lo, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) { source = s; destination = d; timestamp = t; }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet)o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }
        @Override
        public int hashCode(){
            return Objects.hash(source, destination, timestamp);
        }
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */