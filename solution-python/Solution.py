from typing import List


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
            for value in range (0, map[key]):
                sorted.append(key)

        remain.sort()

        return sorted + remain


print(Solution().relativeSortArray([2,3,1,3,2,4,6,19,9,2,7], [2,1,4,3,9,6]))

