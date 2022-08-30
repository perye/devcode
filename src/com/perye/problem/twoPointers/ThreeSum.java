package com.perye.problem.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum/
 *
 * @author perye
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // 枚举first
        for (int first = 0; first < nums.length; first++) {
            // 需要和上一次枚举不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // third对应的指针初始指向数组的最右端
            int third = nums.length - 1;
            int target = -nums[first];
            // 枚举 second
            for (int second = first + 1; second < nums.length; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 second 的指针在 third 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着 second 后续的增加
                // 就不会有满足 first+second+third=0 并且 second<third 的 third 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
