package org.alg.algorithm.jason.week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Descreption: 有重复字符串的排列组合
 * https://leetcode-cn.com/problems/permutation-ii-lcci/
 *
 * Date: 2020年12月24日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q05Permutation {
    public static void main(String args[]){
        String S = "qqe";
        String[] res = new Q05Permutation().permutation(S);
        for (String s : res) {
            System.out.println(s);
        }
    }

    private ArrayList<String> res;
    private boolean[] usedIndex;

    public String[] permutation(String S) {
        StringBuilder sb = new StringBuilder(S.length());
        res = new ArrayList<>();
        usedIndex = new boolean[S.length()];
        backtracking(sb, S, 0);

        String[] strings = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strings[i] = res.get(i);
        }
        return strings;
    }

    private void backtracking(StringBuilder sb, String s, int depth) {
        if (depth == s.length()){
            res.add(sb.toString());
            return;
        }
        Set<Character> usedChar = new HashSet<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (!usedIndex[index] && !usedChar.contains(c)){
                sb.append(c);
                usedChar.add(c);
                usedIndex[index] = true;
                backtracking(sb, s, depth+1);

                // 这里是回溯
                usedIndex[index] = false;
                sb.deleteCharAt(depth);
            }
        }
    }

}
