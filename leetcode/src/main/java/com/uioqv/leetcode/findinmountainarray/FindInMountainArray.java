package com.uioqv.leetcode.findinmountainarray;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 整体思路:
 * 1. 将整个数组分为两种类型,
 *      1.1 有序的数组
 *      1.2 山脉数组
 * 2. 对山脉数组
 *      1.1 将其一分为二一部分为有序数据一部分为山脉数组
 * 3. 对有序数组
 *      执行正常的二分查找
 * @author LiuGuoQing
 * @since 2020-04-29
 */
public class FindInMountainArray {
    static class MountainArray {
        private Integer[] arr = {1, 2, 3, 4, 5, 3, 1};

        private int count;

        public int get(int index) {
            count++;
            return arr[index];
        }

        public int length() {
            return arr.length;
        }

        public int getCount() {
            return count;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        return bSearch(target, mountainArr, 0, mountainArr.length() - 1);
    }

    private int bSearch(int target, MountainArray mountainArr, int left, int right) {

        // 元素少于3个直接遍历
        if (right - left < 3) {
            return loopSearch(left, right, target, mountainArr);
        }

        // 找出中间元素将数据分为一个有序一个无序的数组
        int center = (left + right) / 2;


        // 判断左区间是有序还是无序
        int left0 = mountainArr.get(left);
        int left1 = mountainArr.get(left + 1);
        int center0 = mountainArr.get(center - 1);
        int center1 = mountainArr.get(center);


        // 判断是否有序
        boolean leftIsSample = isSample(left0, left1, center0, center1);

        int lReturn = -1;
        // 左边有序在左边找左边无序继续分
        if (leftIsSample) {
            if (inRange(target, left0, center1)) {
                lReturn = bSearch(target, mountainArr, left, center, left0 < center1);
            }
        } else {
            lReturn = bSearch(target, mountainArr, left, center);
        }

        // 左边找到了返回
        if (lReturn != -1) {
            return lReturn;
        }

//        左边有序则右边无序继续分,
        if (leftIsSample) {
            return bSearch(target, mountainArr, center + 1, right);
        } else {
            int right0 = mountainArr.get(right - 1);
            int right1 = mountainArr.get(right);
            int center2 = mountainArr.get(center + 1);
            if (inRange(target, center2, right1)) {
                return bSearch(target, mountainArr, center + 1, right, right0 < right1);
            }
        }
        return -1;
    }

    /**
     * 左区间的前两个值与后两个值方向一致则是有序
     */
    private boolean isSample(int left0, int left1, int center0, int center1) {
        int lgl = left0 < left1 ? 1 : 0;
        int rgr = center0 < center1 ? 1 : 0;
        return (lgl ^ rgr) == 0;
    }

    /**
     * 循环查找
     */
    private int loopSearch(int left, int right, int target, MountainArray mountainArr) {
        while (left <= right) {
            if (target == mountainArr.get(left)) {
                return left;
            }
            left++;
        }
        return -1;
    }

    /**
     * 判断值在区间内, 减少get调用
     */
    private boolean inRange(int target, int leftVale, int rightValue) {
        if (leftVale < rightValue) {
            return target >= leftVale && target <= rightValue;
        } else {
            return target <= leftVale && target >= rightValue;
        }
    }


    private int bSearch(int target, MountainArray mountainArr, int left, int right, boolean l2r) {
        while (left <= right) {
            int center = (left + right) /2;
            int val = mountainArr.get(center);
            if(target == val) {
                return center;
            }

            if(l2r ?  target < val : target > val) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        return -1;
    }
//
//    /**
//     * 正常排序的数组处理
//     */
//    private int bSearch(int target, MountainArray mountainArr, int left, int right, boolean l2r) {
//        if (left > right) {
//            return -1;
//        }
//        int center = (left + right) / 2;
//        int val = mountainArr.get(center);
//        if (val == target) {
//            return center;
//        }
//        boolean isLeft = l2r ? target < val : target > val;
//        if (isLeft) {
//            return bSearch(target, mountainArr, left, center - 1, l2r);
//        } else {
//
//            return bSearch(target, mountainArr, center + 1, right, l2r);
//        }
//    }


    public static void main(String[] args) throws IOException {
//        int index = new FindInMountainArray().findInMountainArray(3, new MountainArray());
//        System.out.println(index);
//
//        int index1 = new FindInMountainArray().findInMountainArray(9, new MountainArray());
//        System.out.println(index1);
//
//
//        int index2 = new FindInMountainArray().findInMountainArray(2,
//                new MountainArray() {{super.arr = new Integer[]{1,5,2};}});
//        System.out.println(index2);
        InputStream in = FindInMountainArray.class.getClassLoader().getResourceAsStream("findInMountainArrayData");


        ObjectMapper mapper = new ObjectMapper();
        List<Integer> data = mapper.readValue(in, new TypeReference<List<Integer>>() {
        });
        System.out.println(data);
        Integer[] dataArray = data.toArray(new Integer[data.size()]);
        MountainArray mountainArray = new MountainArray() {{
            super.arr = dataArray;
        }};
        int index3 = new FindInMountainArray().findInMountainArray(450002,
                mountainArray);
        System.out.println(index3);
        System.out.println(mountainArray.getCount());
    }

}
