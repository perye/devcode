package com.perye.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author perye
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 2 * n, 0, n, "", ans);
        return ans;
    }

    /**
     *
     * @param i 当前遍历到的位置
     * @param n 字符总长度
     * @param score 当前得分，令 '(' 为 1， ')' 为 -1
     * @param max 最大得分值
     * @param path 当前的拼接结果
     * @param ans 最终结果集
     */
    void dfs(int i, int n, int score, int max, String path, List<String> ans) {
        if (i == n) {
            if (score == 0) {
                ans.add(path);
            }
        } else {
            // 如果添加左括号后不超过 max（有效值），则可以添加
            if (score + 1 <= max) {
                dfs(i + 1, n, score + 1, max, path + "(", ans);
            }
            // 如果添加右括号后不少于 0（有效值），则可以添加
            if (score - 1 >= 0) {
                dfs(i + 1, n, score - 1, max, path + ")", ans);
            }
        }
    }

}
