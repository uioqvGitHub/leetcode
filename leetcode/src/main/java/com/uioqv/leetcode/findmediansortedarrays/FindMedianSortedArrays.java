package com.uioqv.leetcode.findmediansortedarrays;

/**
 * @author LiuGuoQing
 * @since 2020-04-30
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int allLength = nums1.length + nums2.length;
        boolean one = (allLength & 1) == 1;
        int i = 0, j = 0;
        // 只遍历到一半就可以了
        int center = (allLength - 1) / 2;
        while (i + j < center) {
            if (nextNumA(nums1, nums2, i, j)) {
                i++;
            } else {
                j++;
            }
        }
        if (one) {
            return getNextNum(nums1, nums2, i, j);
        }

//        偶数的话要再取一个数
        int a1 = getNextNum(nums1, nums2, i, j);
        if (nextNumA(nums1, nums2, i, j)) {
            i++;
        } else {
            j++;
        }
        int b1 = getNextNum(nums1, nums2, i, j);
        return (a1 + b1) / 2.0;
    }

    /**
     * 返回两个数组中最小的数
     * @return
     */
    private int getNextNum(int[] nums1, int[] nums2, int indexA, int indexB) {
        return nextNumA(nums1, nums2, indexA, indexB) ? nums1[indexA] : nums2[indexB];
    }

    /**
     * 获取两个数组中的最小的数是在A还是B
     * @return
     */
    private boolean nextNumA(int[] nums1, int[] nums2, int indexA, int indexB) {
        // 数组1被燃尽
        if (indexA >= nums1.length) {
            return false;
        }
        // 数组2被燃尽
        if (indexB >= nums2.length) {
            return true;
        }
        // 判断a是否小于b
        int a = nums1[indexA];
        int b = nums2[indexB];
        return a < b;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double r1 = new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(r1);


        int[] nums11 = {1, 2};
        int[] nums22 = {-1, 3};
        double r2 = new FindMedianSortedArrays().findMedianSortedArrays(nums11, nums22);
        System.out.println(r2);


        int[] nums111 = {0, 0};
        int[] nums222 = {0, 0};
        double r3 = new FindMedianSortedArrays().findMedianSortedArrays(nums111, nums222);
        System.out.println(r3);


        int[] nums1111 = {};
        int[] nums2222 = {1};
        double r4 = new FindMedianSortedArrays().findMedianSortedArrays(nums1111, nums2222);
        System.out.println(r4);

    }
}
