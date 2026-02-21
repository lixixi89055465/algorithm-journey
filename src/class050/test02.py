from typing import List

from sqlalchemy import nullsfirst
from sqlalchemy.dialects.postgresql import psycopg_async


class Code02_FindTheDuplicateNumber:
    def __init__(self):
        pass

    def findDuplicate(self, nums: List[int]):
        if not nums or len(nums) < 2:
            return -1
        slow = nums[0]
        fast = nums[nums[0]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
        fast = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow
