package com.perye.math;

/**
 * 171. Excel表列序号
 * 数学
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 *
 * @author honggd
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

}
