package java.easy;
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        return (n & (n-1)) == 0 && Integer.bitCount(n - 1) % 2==0;
    }
}