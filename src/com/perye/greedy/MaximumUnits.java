package com.perye.greedy;


import java.util.Arrays;

/**
 * 1710. 卡车上的最大单元数
 * 贪心算法、排序
 * 链接：https://leetcode-cn.com/problems/maximum-units-on-a-truck/
 *
 * @author honggd
 */
public class MaximumUnits {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, ((o1, o2) -> o2[1] - o1[1]));
        int ans = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int num = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= num;
            ans += num * boxTypes[i][1];
        }
        return ans;
    }

}
