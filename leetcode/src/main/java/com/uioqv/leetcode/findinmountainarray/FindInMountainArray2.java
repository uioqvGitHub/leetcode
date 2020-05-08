package com.uioqv.leetcode.findinmountainarray;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author LiuGuoQing
 * @since 2020-04-29
 */
public class FindInMountainArray2 {
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
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int center = (left + right) /2;
            if(mountainArr.get(center) < mountainArr.get(center + 1)) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        int max = left;
        int lValue = bSearch(target, mountainArr, 0, max, true);
        if(lValue != -1) {
            return lValue;
        }

        return bSearch(target, mountainArr, max + 1, mountainArr.length() - 1, false);
    }

    private int bSearch(int target, MountainArray mountainArr, int left, int right, boolean isLeft) {
        while (left <= right) {
            int center = (left + right) /2;
            int val = mountainArr.get(center);
            if(target == val) {
                return center;
            }

            if(isLeft ?  target < val : target > val) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        int index = new FindInMountainArray2().findInMountainArray(3, new MountainArray());
        System.out.println(index);

        int index1 = new FindInMountainArray2().findInMountainArray(9, new MountainArray());
        System.out.println(index1);


        int index2 = new FindInMountainArray2().findInMountainArray(1,
                new MountainArray() {{super.arr = new Integer[]{0,5,3,1};}});
        System.out.println(index2);
        InputStream in = FindInMountainArray.class.getClassLoader().getResourceAsStream("findInMountainArrayData");


        ObjectMapper mapper = new ObjectMapper();
        List<Integer> data = mapper.readValue(in, new TypeReference<List<Integer>>() {
        });
        System.out.println(data);
        Integer[] dataArray = data.toArray(new Integer[data.size()]);
        MountainArray mountainArray = new MountainArray() {{
            super.arr = dataArray;
        }};
        int index3 = new FindInMountainArray2().findInMountainArray(450002,
                mountainArray);
        System.out.println(index3);
        System.out.println(mountainArray.getCount());
    }

}
