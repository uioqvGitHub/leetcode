package com.uioqv.leetcode.numsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 双重循环遍历获得
 * @author LiuGuoQing
 * @since 2020-04-27
 */
public class AllSelect {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetIndex = new HashMap<>();
        targetIndex.put(target - nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            Integer index = targetIndex.get(nums[i]);
            if(index != null) {
                return new int[]{index, i};
            }
            targetIndex.put(target - nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] ints = new AllSelect().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
