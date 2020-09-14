package net.slipp.algorithm.solution.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * Medium
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {

        int[] nums = {830, 8308};
//        int[] nums = {0,0};
//        int[] nums = {121,12};
//        int[] nums = {3,30,34,5,9};

        System.out.println(largestNumber(nums));

    }


    static String largestNumber(int[] nums) {


        Comparator<String> stringOrderComparator =

            (o1, o2) -> {

                if (o1.equals(o2)) {
                    return 0;
                } else {
                    long forward = Long.parseLong(o1 + o2);
                    long reverse = Long.parseLong(o2 + o1);

                    return forward >= reverse ? -1 : 1;
                }
            };

        String result = Arrays.stream(nums).mapToObj(String::valueOf).sorted(stringOrderComparator).collect(Collectors.joining());

        return result.charAt(0) == '0' ? "0" : result;

    }

}
