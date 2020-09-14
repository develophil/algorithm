import math
import os
import random
import re
import sys

from typing import List
from functools import cmp_to_key

class Solution:

    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        map = {n: 0 for n in arr2}

        sorted = []
        remain = []

        for n in arr1:
            if map.__contains__(n):
                map[n] += 1
            else:
                remain.append(n)

        for key in map:
            for value in range(0, map[key]):
                sorted.append(key)

        remain.sort()

        return sorted + remain

    def largestNumber(self, nums=[]):

        def stringOrderCompare(s1, s2):
            if s1 == s2:
                return 0
            else:
                return -1 if int(s1 + s2) > int(s2 + s1) else 1

        result = "".join(sorted(list(map(str, nums)), key=cmp_to_key(stringOrderCompare)))

        return result if result[0] != "0" else "0"



# print(Solution().relativeSortArray([2,3,1,3,2,4,6,19,9,2,7], [2,1,4,3,9,6]))
# print(Solution().largestNumber([121,12]))
# print(Solution().largestNumber([3,30,34,5,9]))
print(Solution().largestNumber([0, 0, 0]))
