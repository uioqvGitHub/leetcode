package com.uioqv.leetcode.ocountnum;

import java.util.Arrays;

/**
 * @author LiuGuoQing
 * @since 2020-04-28
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            if(result[0] == nums[i]) {
                result[0] = 0;
            } else if(result[1] == nums[i]) {
                result[1] = 0;
            } else if(result[0] == 0) {
                result[0] = nums[i];
            }else if(result[1] == 0) {
                result[1] = nums[i];
            } else {
                for (int j =i+1; j<nums.length; j++) {
                    if(nums[i] == nums[j]) {
                        nums[j] = 0;
                        break;
                    }
                    if(result[0] == nums[j]) {
                        nums[j] = 0;
                        result[0] = 0;
                        result[0] = nums[i];
                        break;
                    }
                    if(result[1] == nums[j]) {
                        nums[j] = 0;
                        result[1] = 0;
                        result[1] = nums[i];
                        break;
                    }
                }
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
        int[] result1 = new SingleNumbers().singleNumbers(test1);
        int[] result2 = new SingleNumbers().singleNumbers(test2);
        int[] result3 = new SingleNumbers().singleNumbers(test3);
        int[] result4 = new SingleNumbers().singleNumbers(test4);
        int[] result5 = new SingleNumbers().singleNumbers(test5);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
        System.out.println(Arrays.toString(result5));
    }
}
