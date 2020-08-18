package net.slipp.algorithm.solution.week2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 1122. Relative Sort Array
 * https://leetcode.com/problems/relative-sort-array/
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};


        Map<Integer, Integer> map = Arrays.stream(arr2).boxed().collect(toMap(Function.identity(), o -> 0, Integer::compareTo, LinkedHashMap::new));

        List<Integer> sorted = new ArrayList<>();
        List<Integer> remain = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {

            int value = arr1[i];

            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                remain.add(value);
            }
        }

        map.forEach((num, count) -> {

            for (int i = 0; i < count; i++) {
                sorted.add(num);
            }
        });

        int[] result = Stream.concat(sorted.stream(), remain.stream().sorted()).mapToInt(Integer::intValue).toArray();

        System.out.println("result : " + Arrays.toString(result));
    }

}
