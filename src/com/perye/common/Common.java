package com.perye.common;

import com.perye.linked.ListNode;

/**
 * 常用方法
 */
public class Common {

    /**
     * 计算a和b的最大公约数
     *
     * @param a a
     * @param b b
     * @return a和b的最大公约数
     */
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    /**
     * 快速幂
     * @param x     底数
     * @param n     指数
     * @param mod   取余
     * @return ans  结果
     */
    public static Double quickMul(double x, long n, double mod) {
        double ans = 1.0;
        if (n < 0) {
            ans = quickMul(x, -n, mod);
            return Double.isNaN(ans) ? 0 : 1.0 / ans;
        }
        // 贡献初始值
        double contribute = x;
        // 二进制拆分
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * contribute % mod;
            }
            contribute = contribute * contribute % mod;
            n >>= 1;
        }
        return ans;
    }

    /**
     * 快速幂
     * @param x     底数
     * @param n     指数
     * @return ans  结果
     */
    public static Double quickMul(double x, long n) {
        double ans = 1.0;
        if (n < 0) {
            ans = quickMul(x, -n);
            return Double.isNaN(ans) ? 0 : 1.0 / ans;
        }
        // 贡献初始值
        double contribute = x;
        // 二进制拆分
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * contribute;
            }
            contribute = contribute * contribute;
            n >>= 1;
        }
        return ans;
    }


    /**
     * 链表的中间结点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
