class Solution {
    public int findClosest(int x, int y, int z) {
        int dx = Math.abs(x - z);
        int dy = Math.abs(y - z);
        if (dx < dy)
            return 1;
        else if (dx > dy)
            return 2;
        return 0;
    }
}