package com.uioqv.leetcode.sirsa;

/**
 * @author LiuGuoQing
 * @since 2020-04-27
 */
public class LoopBSearch {
    public int search(int[] nums, int target) {
        int pre = 0;
        boolean initPre = false;
        for (int i = 0; i < nums.length; i++) {
            if (initPre && nums[i] < pre) {
                return bSearch(nums, i, nums.length - 1, target);
            }
            if (nums[i] == target) {
                return i;
            }
            pre = nums[i];
            initPre = true;
        }
        return -1;
    }

    private int bSearch(int[] nums, int start, int end, int target) {
        int center = (end + start) / 2;
        if (end < start) {
            return -1;
        }
        if (target > nums[center]) {
            return bSearch(nums, center+1, end, target);
        } else if (target < nums[center]) {
            return bSearch(nums, start, center-1, target);
        }
        return center;
    }

    public static void main(String[] args) {
        int[] input = {4,5,6,7,0,1,2};
        int search = new BSearch().search(input, 8);
        System.out.println(search);
        search = new BSearch().search(input, 3);
        System.out.println(search);
    }

}
