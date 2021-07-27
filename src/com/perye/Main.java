package com.perye;


import com.perye.moban.IntegerKM;
import com.perye.tree.TreeNode;
import com.perye.unionFind.UnionFind;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;

/**
 * @author honggd
 */
public class Main {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class ListNode {

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

    static class TreeNode {

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
        Solution solution = new Solution();
//        System.out.println(letterCombinations("23"));
        //

    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(0, 2 * n, 0, n, "", ans);
        return ans;
    }

    private void backtrack(int begin, int n, int score, int max, String path, List<String> ans) {
        if (begin == n) {
            if (score == 0) {
                ans.add(path);
            }
        } else {
            if (score + 1 <= max) {
                backtrack(begin + 1, n, score + 1, max, path + "(", ans);
            }
            if (score - 1 >= 0) {
                backtrack(begin + 1, n, score - 1, max, path + ")", ans);
            }
        }
    }

    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val != val) {
            if (ans == -1) {
                ans = root.val;
            } else {
                ans = Math.min(ans, root.val);
            }
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }


}
