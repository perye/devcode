package com.perye.problem.math;

/**
 * 1232. 缀点成线
 * 数学、几何、数组
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 *
 * @author honggd
 */
public class StraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        int dy = coordinates[1][1]-coordinates[0][1];
        int dx = coordinates[1][0]-coordinates[0][0];
        for (int i = 1; i < coordinates.length; i++) {
            int dyi = coordinates[i][1]-coordinates[0][1];
            int dxi = coordinates[i][0]-coordinates[0][0];
            if(dy*dxi!=dyi*dx) {
                return false;
            }
        }
        return true;
    }
}
