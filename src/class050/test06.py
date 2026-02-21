from typing import List


class Code06_Heaters:
    def __init__(self):
        pass

    def findRadius(self, houses: List[int], heaters: List[int]):
        houses.sort()
        heaters.sort()
        ans = 0
        j = 0
        for i in range(len(houses)):
            while not self.best(houses, heaters, i, j):
                j += 1
            ans = max(ans, abs(houses[i] - heaters[j]))
        return ans

    def best(self, houses, heaters, i, j):
        return (j == len(heaters) - 1 or
                abs(heaters[j] - houses[i]) < abs(heaters[j + 1] - houses[j]))
