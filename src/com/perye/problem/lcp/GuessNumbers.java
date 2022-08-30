package com.perye.problem.lcp;

/**
 * LCP 01. 猜数字
 * 链接：https://leetcode-cn.com/problems/guess-numbers/
 *
 * @author honggd
 */
public class GuessNumbers {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (answer[i] == guess[i]) {
                count++;
            }
        }
        return count;
    }

}
