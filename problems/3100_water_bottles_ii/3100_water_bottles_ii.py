class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        drank = numBottles
        empties = numBottles
        while empties >= numExchange:
            empties = empties - numExchange + 1
            numExchange += 1
            drank += 1
        return drank
