package com.perye;


import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author honggd
 */
public class Main {

    class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
//        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
//        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(MinMoves.minMoves(new int[]{1, 2, 3}));
//        System.out.println(replaceDigits("a1c1e1"));
//        System.out.println(getMinDistance(new int[]{5, 3, 6}, 5, 2));
//        System.out.println(splitString("050043"));
//        System.out.println(ExcelSheetColumnTitle.convertToTitle(1));
//        System.out.println(ExcelSheetColumnTitle.convertToTitle(28));
//        System.out.println("5555".substring(3));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(wordPattern("abba","dog cat cat dog"));
//        System.out.println(hammingDistance(3, 1));
//        System.out.println(dominantIndex(new int[]{1}));
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


}
