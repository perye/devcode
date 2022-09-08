package com.perye.problem.linked;

/**
 * 206. 反转链表
 * 链表
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author honggd
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
