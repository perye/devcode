package com.perye.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * 数组、位运算、回溯算法
 * 链接：https://leetcode-cn.com/problems/power-set-lcci/
 *
 * @author honggd
 */
public class PowerSetLcci {

    public List<List<Integer>> subsets(int[] nums) {
        // 子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        // 遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 如果数字i的某一个位置是1，就把数组中对应的数字添加到集合
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
