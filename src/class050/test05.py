from typing import List


class Code05_ContainerWithMostWater:
    def __init__(self):
        pass

    def maxArea(self, height: List[int]):
        l = 0
        r = len(height) - 1
        while l < r:
            ans = max(ans, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ans
