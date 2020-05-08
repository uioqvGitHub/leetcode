package com.uioqv.leetcode.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuGuoQing
 * @since 2020-04-29
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }


        int max = 0;
        int windowLeft = 0;
        int windowRight = 0;
        Map<Character, Integer> valueIndex = new HashMap<>();

        while (windowRight < s.length()) {
            Integer val = valueIndex.put(s.charAt(windowRight), windowRight);
            if(val != null && val >= windowLeft) {
                max = Math.max(windowRight - windowLeft, max);
                windowLeft = val + 1;
            }
            windowRight++;
        }


        max = Math.max(windowRight - windowLeft, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }


}
