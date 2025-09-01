class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>((a, b) -> {
            if (a.gain < b.gain)
                return 1;
            else if (a.gain > b.gain)
                return -1;
            else
                return 0;
        });

        for (int[] c : classes) {
            pq.add(new ClassRecord(c));
        }
        while (extraStudents > 0) {
            pq.add(pq.poll().addStudent());
            extraStudents--;
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            ClassRecord cr = pq.poll();
            sum += (double) cr.pass / cr.total;
        }
        return sum / classes.length;
    }

    class ClassRecord {
        int pass;
        int total;
        double gain;

        public ClassRecord(int[] arr) {
            pass = arr[0];
            total = arr[1];
            gain = calculateGain();
        }

        public ClassRecord addStudent() {
            pass++;
            total++;
            gain = calculateGain();
            return this;
        }

        public double calculateGain() {
            return (pass + 1.0) / (total + 1.0) - (double) pass / total;
        }
    }
}