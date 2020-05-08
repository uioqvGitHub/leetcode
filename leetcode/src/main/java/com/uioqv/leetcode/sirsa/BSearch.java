package com.uioqv.leetcode.sirsa;

/**
 * @author LiuGuoQing
 * @since 2020-04-27
 */
public class BSearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return loopBSearch(nums, 0, nums.length - 1, target);
    }


    private int loopBSearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int center = (end + start) / 2;
            if (target == nums[center]) {
                return center;
            }

            if (nums[start] <= nums[center]) {
                if (target >= nums[start] && target <= nums[center]) {
                    end = center - 1;
                } else {
                    start = center + 1;
                }
            } else {
                if (target >= nums[center] && target <= nums[end]) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }
        return -1;
    }

    private int bSearch(int[] nums, int start, int end, int target) {
        int center = (end + start) / 2;


        if (end < start) {
            return -1;
        }
        if (target == nums[center]) {
            return center;
        }

        if (nums[start] <= nums[center]) {
            if (target >= nums[start] && target <= nums[center]) {
                return bSearch(nums, start, center - 1, target);
            }
            return bSearch(nums, center + 1, end, target);
        } else {
            if (target >= nums[center] && target <= nums[end]) {
                return bSearch(nums, center + 1, end, target);
            }
            return bSearch(nums, start, center - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int search = new BSearch().search(input, 9);
        System.out.println(search);
        search = new BSearch().search(input, 3);
        System.out.println(search);
    }


}
