class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles;
        int empties = numBottles; // 初始空瓶數（喝掉所有瓶子後變為空瓶）
        while (empties >= numExchange) {
            // 用空瓶兌換 + 喝掉新瓶後的效果
            empties = empties - numExchange + 1;
            numExchange++;
            drank++;
        }
        return drank;
    }
}