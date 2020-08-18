package net.slipp.algorithm.solution.week1;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 *
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * For example , the list of all anagrammatic pairs is  at positions  respectively.
 *
 * Function Description
 *
 * Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .
 *
 * sherlockAndAnagrams has the following parameter(s):
 *
 * s: a string .
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a string  to analyze.
 *
 * Constraints
 *
 *
 *
 * String  contains only lowercase letters  ascii[a-z].
 *
 * Output Format
 *
 * For each query, return the number of unordered anagrammatic pairs.
 *
 * Sample Input 0
 *
 * 2
 * abba
 * abcd
 * Sample Output 0
 *
 * 4
 * 0
 * Explanation 0
 *
 * The list of all anagrammatic pairs is  and  at positions  and  respectively.
 *
 * No anagrammatic pairs exist in the second query as no character repeats.
 *
 * Sample Input 1
 *
 * 2
 * ifailuhkqq
 * kkkk
 * Sample Output 1
 *
 * 3
 * 10
 * Explanation 1
 *
 * For the first query, we have anagram pairs  and  at positions  and  respectively.
 *
 * For the second query:
 * There are 6 anagrams of the form  at positions  and .
 * There are 3 anagrams of the form  at positions  and .
 * There is 1 anagram of the form  at position .
 *
 * Sample Input 2
 *
 * 1
 * cdcd
 * Sample Output 2
 *
 * 5
 * Explanation 2
 *
 * There are two anagrammatic pairs of length :  and .
 * There are three anagrammatic pairs of length :  at positions  respectively.
 */
public class SherlokAndAnagrams {


    static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        int k = 1;
        for (int i = 2; i <= n; i++) {
            k *= i;
        }
        return k;
    }

    static int combination(int n) {

        int r = 2;

        return factorial(n) / factorial(r) / factorial(n-r);
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        int size = s.length();

        if (size < 2 || size > 100) {
            return 0;
        }


        Map<String, Integer> map = new HashMap<>();


        for (int i = 1; i < size ; i++) {

            for (int j = 0; j <= size-i ; j++) {

                String sortedTarget = sort(s.substring(j, j + i));
                if (map.containsKey(sortedTarget)) {
                    map.put(sortedTarget, map.get(sortedTarget) + 1);
                } else {
                    map.put(sortedTarget, 1);
                }
            }
        }

        System.out.println(map);

        return map.values().stream().filter(i -> i > 1).mapToInt(SherlokAndAnagrams::combination).sum();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = "ifailuhkqq";

        int result = sherlockAndAnagrams(s);

        System.out.println(result);
    }
}

