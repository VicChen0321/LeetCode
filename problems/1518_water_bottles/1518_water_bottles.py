class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        drank = numBottles
        empty = numBottles

        while empty >= numExchange:
            new_bottles = empty // numExchange
            drank += new_bottles
            empty = empty % numExchange + new_bottles

        return drank