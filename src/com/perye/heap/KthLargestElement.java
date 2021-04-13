package com.perye.heap;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 堆、动态规划
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author honggd
 */
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

}
