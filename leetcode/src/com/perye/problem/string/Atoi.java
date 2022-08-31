package com.perye.problem.string;

/**
 * @author honggd
 */
public class Atoi {

    public static int myAtoi(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        char[] arr = new char[chars.length];
        int index = 0;
        if (chars.length == 0) {
            return 0;
        }
        if (!(Character.isDigit(chars[0]) || chars[0] == '-' || chars[0] == '+')) {
            return 0;
        } else {
            arr[index++] = chars[0];
        }
        for (int i = 1; i < chars.length; i++) {
            // 判断是否是数字
            if (Character.isDigit(chars[i])) {
                arr[index++] = chars[i];
            } else {
                break;
            }
        }
        // 转成数字
        long rev = 0L;
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) {
                continue;
            }
            rev = arr[0] == '-' ? -Math.abs(rev) * 10 - (chars[i] - '0') : Math.abs(rev) * 10 + (chars[i] - '0');
        }
        if (rev >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (rev <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return Math.toIntExact(rev);
        }
    }

}
