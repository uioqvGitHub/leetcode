package com.uioqv.leetcode.ishappy;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LiuGuoQing
 * @since 2020-04-30
 */
public class IsHappy {

    private Set<Integer> failNum = new HashSet<>();

    public boolean isHappy(int n) {
        if(failNum.contains(n)) {
            return false;
        }

        Set<Integer> loopN = new HashSet<>();
        while (n != 1) {
            loopN.add(n);
            n = loopOne(n);
            if(loopN.contains(n)) {
                failNum.addAll(loopN);
                return false;
            }
        }
        return true;
    }

    public int loopOne(int n) {
        int sum = 0;
        do {
            int i = n % 10;
            int j = i * i;
            sum += j;
        } while ((n = n/10) != 0);
        return sum;
    }


    public static void main(String[] args) {
        int test1 = new IsHappy().loopOne(19);
        System.out.println(test1);

        boolean test2 = new IsHappy().isHappy(19);
        System.out.println(test2);
    }
}
