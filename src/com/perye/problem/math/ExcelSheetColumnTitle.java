package com.perye.problem.math;


/**
 * 168. Excel表列名称
 * 数学
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title/
 *
 * @author honggd
 */
public class ExcelSheetColumnTitle {

    static String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    static StringBuilder sb = new StringBuilder();

    public static String convertToTitle(int columnNumber) {
        if (columnNumber > letters.length ) {
            convertToTitle((columnNumber - 1) / letters.length);
        }
        sb.append(letters[(columnNumber - 1) % letters.length]);
        return sb.toString();
    }



}
