package com.uioqv.leetcode.ocountnum;

import java.util.Arrays;

/**
 * @author LiuGuoQing
 * @since 2020-04-28
 */
public class SingleNumbersXOR {

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for(int n : nums) {
            x ^= n;
        }
        int nx = 1;
        while ((nx & x) == 0) {
            nx <<= 1;
        }
        int[] result = new int[2];
        for(int n : nums) {
            if((nx & n) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {4,1,4,6};
        int[] test2 = {1,2,10,4,1,4,3,3};
        int[] test3 = {6,5,5,9,10,9,4,10};
        int[] test4 = {7,1,7,2,6,6,3,1};
        int[] test5 = {3,6,3,6,2,1,10,1};
        int[] result1 = new SingleNumbersXOR().singleNumbers(test1);
        int[] result2 = new SingleNumbersXOR().singleNumbers(test2);
        int[] result3 = new SingleNumbersXOR().singleNumbers(test3);
        int[] result4 = new SingleNumbersXOR().singleNumbers(test4);
        int[] result5 = new SingleNumbersXOR().singleNumbers(test5);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
        System.out.println(Arrays.toString(result5));
    }
}
