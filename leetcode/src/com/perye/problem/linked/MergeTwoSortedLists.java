package com.perye.problem.linked;

/**
 * 21. 合并两个有序链表
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author perye
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
