package com.perye.string;

import java.util.Stack;

/**
 * 38. 外观数列
 * 字符串
 * 链接：https://leetcode-cn.com/problems/count-and-say/
 *
 * @author honggd
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String str = "1";
        while (n-- > 1) {
            str = countAndSay(str);
        }
        return str;
    }

    public static String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek() != c) {
                sb.append(count).append(stack.peek());
                stack.push(c);
                count = 1;
            } else {
                stack.push(c);
                count++;
            }
        }
        sb.append(count).append(stack.peek());
        return sb.toString();
    }

}
