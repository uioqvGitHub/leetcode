package com.uioqv.leetcode.bnwab;

/**
 * @author LiuGuoQing
 * @since 2020-04-27
 */
public class Bit {
    public boolean hasAlternatingBits(int n) {
        int p2 = ((n >> 1) ^ n) + 1;
        return Integer.bitCount(p2) == 1;
    }

    public static void main(String[] args) {
        boolean b = new Bit().hasAlternatingBits(4);
        System.out.println(b);
    }
}
