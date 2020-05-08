package com.uioqv.leetcode.maxareaofisland;

import com.uioqv.leetcode.ocountnum.SingleNumbersXOR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author LiuGuoQing
 * @since 2020-04-28
 */
public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    int size = size(grid, i, j);
                    if(size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }
        return maxSize;
    }

    private int size(int[][] grid, int x, int y) {
        if(grid[x][y] == 1) {
            grid[x][y] = 0;
            int size = 1;
            if(x+1 < grid.length) {
                size += size(grid, x+1, y);
            }

            if(x-1 >= 0) {
                size += size(grid, x-1, y);
            }

            if(y+1 < grid[x].length) {
                size += size(grid, x, y+1);
            }

            if(y-1 >= 0) {
                size += size(grid, x, y-1);
            }
            return size;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] test1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int result = new MaxAreaOfIsland().maxAreaOfIsland(test1);
        System.out.println(result);

        System.out.println(new MaxAreaOfIsland().size(test1, 1, 7));
    }
}
