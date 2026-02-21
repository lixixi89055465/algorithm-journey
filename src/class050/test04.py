from typing import List


class Code04_BoatsToSavePeople:
    def __init__(self):
        pass

    def numRescueBoats(self, people: List[int], limit):
        people.sort()
        ans = 0
        l = 0
        r = len(people) - 1
        sum = 0
        while l < r:
            sum = people[l] if l == r else people[l] + people[r]
            if sum > limit:
                r -= 1
            else:
                r -= 1
                l += 1
            ans += 1
        return ans
