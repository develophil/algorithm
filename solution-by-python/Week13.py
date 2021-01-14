import math
import os
import random
import re
import sys

from typing import List
from functools import cmp_to_key


class Solution:

    '''
    #1. 316. Remove Duplicate Letters - https://leetcode.com/problems/remove-duplicate-letters/

    '''
    def removeDuplicateLetters(self, s: str) -> str:
        pass

    '''
    #2. 406. Queue Reconstruction by Height - https://leetcode.com/problems/queue-reconstruction-by-height/
    '''
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        pass



    '''
    #3. 131. Palindrome Partitioning - https://leetcode.com/problems/palindrome-partitioning/
    
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
    A palindrome string is a string that reads the same backward as forward.
    
    Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
    
    Example 2:
    Input: s = "a"
    Output: [["a"]]
    
    Constraints:
    1 <= s.length <= 16
    s contains only lowercase English letters.
    '''
    def partition(self, s: str) -> List[List[str]]:

        from collections import defaultdict

        graph = defaultdict(list)

        def store_character(i, c):
            graph[i] += c
            i -= 1
            if i >= 0:
                store_character(i, c)
            else:
                return

        def split_palindrome(i):
            pass


        for i, c in enumerate(s):
            store_character(i, c)
            split = split_palindrome(i)
            self.partition(split)

        print(graph)




## week13
print(Solution().partition("aab"))   #[["a","a","b"],["aa","b"]]
