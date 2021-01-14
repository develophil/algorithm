import math
import os
import random
import re
import sys

from typing import List
from functools import cmp_to_key


class Solution:

    '''
    #1. 994. Rotting Oranges - https://leetcode.com/problems/rotting-oranges/
    Input: [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4
    Input: [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    Input: [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    
    Note:
    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] is only 0, 1, or 2.
    '''
    def orangesRotting(self, grid: List[List[int]]) -> int:

        def rotting(target_idx, arr):

            if target_idx < 0 or target_idx >= len(arr) or arr[target_idx] == 0:
                return False

            if arr[target_idx] == 1:
                arr[target_idx] = 2
                return True

        size = len(grid)

        n1_grid = [element for array in grid for element in array]

        on_going = True
        minutes = 0
        direction_indice = [1, -1, size, -1 * size] # 동,서,남,북

        temp = []

        # 1.상한 오렌지 index
        for idx, val in enumerate(n1_grid):
            if val == 2:
                temp.append(idx)


        while on_going:

            changed = False
            next_temp = []

            # 2. 상한 오렌지 전염
            for idx in temp:

                for w in direction_indice:
                    target_idx = idx - w
                    if rotting(target_idx, n1_grid):
                        changed = True
                        next_temp.append(target_idx)

            if changed:
                minutes += 1
            else:
                on_going = False

            temp = next_temp


        return minutes


    '''
    #2. 819. Most Common Word - https://leetcode.com/problems/most-common-word/
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
    Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
    
    Example:
    Input: 
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    Output: "ball"
    Explanation: 
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"), 
    and that "hit" isn't the answer even though it occurs more because it is banned.
     
    Note:
    1 <= paragraph.length <= 1000.
    0 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.
    '''
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        pass




    '''
    #3. 1005. Maximize Sum Of Array After K Negations - https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
    Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
    Return the largest possible sum of the array after modifying it in this way.
    
    Example 1:
    Input: A = [4,2,3], K = 1
    Output: 5
    Explanation: Choose indices (1,) and A becomes [4,-2,3].
    
    Example 2:
    Input: A = [3,-1,0,2], K = 3
    Output: 6
    Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
    
    Example 3:
    Input: A = [2,-3,-1,5,-4], K = 2
    Output: 13
    Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
    
    Note:
    1 <= A.length <= 10000
    1 <= K <= 10000
    -100 <= A[i] <= 100
    '''
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        pass


## week9
# print(Solution().orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))   #
print(Solution().orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))   #
