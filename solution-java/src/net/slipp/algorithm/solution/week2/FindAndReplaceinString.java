package net.slipp.algorithm.solution.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/
 *
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 *
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 *
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 *
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 *
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 *
 * Example 1:
 *
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * Example 2:
 *
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * Notes:
 *
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 */
public class FindAndReplaceinString {

    public static void main(String[] args) {

//        String s = "abcdefghijklmn";
//        int[] indexes = {0, 6};
//        String[] sources = {"abc", "ghij"};
//        String[] targets = {"aaabbbccc", "bbbbbbb"};

        String s = "vmokgggqzp";
        int[] indexes = {3,5,1};
        String[] sources = {"kg","ggq","mo"};
        String[] targets = {"s","so","bfr"};

        System.out.println(findReplaceString(s, indexes, sources, targets));
    }


    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        Map<Integer, String> indexByCharacterMap = IntStream.range(0, S.length()).boxed().collect(Collectors.toMap(Function.identity(), i -> String.valueOf(S.charAt(i))));

        for (int i = 0; i < indexes.length; i++) {

            String currentSourceStr = sources[i];

            int currentStartIndex = indexes[i];
            int currentEndIndex = currentStartIndex + currentSourceStr.length();

            String strAtCurrentIndex = S.substring(currentStartIndex, currentEndIndex);

            if (strAtCurrentIndex.equals(currentSourceStr)) {

                indexByCharacterMap.put(currentStartIndex, targets[i]);

                for (int j = currentStartIndex + 1; j < currentEndIndex; j++) {
                    indexByCharacterMap.remove(j);
                }
            }
        }

        return String.join("", indexByCharacterMap.values());
    }
}
