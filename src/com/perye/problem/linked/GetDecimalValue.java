package com.perye.problem.linked;

/**
 * 1290. 二进制链表转整数
 * 链表
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author honggd
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }
}
