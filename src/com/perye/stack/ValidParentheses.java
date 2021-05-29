package com.perye.stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 栈
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author honggd
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty()) {
                if ((stack.peek() == '(' && c == ')')
                        || (stack.peek() == '[' && c == ']')
                        || (stack.peek() == '{' && c == '}')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
