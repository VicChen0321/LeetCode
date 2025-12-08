class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        char[] chars = directions.toCharArray();

        int left = 0;
        while (left < n && chars[left] == 'L')
            left++;

        int right = n - 1;
        while (right >= 0 && chars[right] == 'R')
            right--;

        int collisions = 0;
        for (int i = left; i <= right; i++) {
            if (chars[i] != 'S')
                collisions++;
        }
        return collisions;
    }
}