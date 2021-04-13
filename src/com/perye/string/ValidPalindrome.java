package com.perye.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 125.验证回文串
 * 双指针、字符串
 * 链接：https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author honggd
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char c : charArray) {
            c = Character.toLowerCase(c);
            if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z')) {
                characters.add(c);
            }
        }
        Character[] array = characters.toArray(new Character[]{});
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (!array[left++].equals(array[right--])) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgoodRev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgoodRev.toString());
    }



}
