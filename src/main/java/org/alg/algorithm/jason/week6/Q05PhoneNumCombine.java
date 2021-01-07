package org.alg.algorithm.jason.week6;

import java.util.*;

public class Q05PhoneNumCombine {
    public static void main(String[] args) {
        String str = "23";
        char c = str.charAt(0);
        List<String> strings = new Q05PhoneNumCombine().letterCombinations(str);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private Map<Character, char[]> map;
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(digits.length());
        dfs(digits, sb, 0);
        return res;
    }

    private void dfs(String digits, StringBuilder sb, int depth) {
        if (depth < digits.length()){
            char[] chars = map.get(digits.charAt(depth));
            for (char c : chars) {
                sb.append(c);
                if (depth == digits.length()-1){
                    res.add(sb.toString());
                } else {
                    dfs(digits, sb, depth+1);
                }
                sb.deleteCharAt(depth);
            }
        }
    }

    {
        map = new HashMap<>();

        char[] board2 = {'a', 'b', 'c'};
        map.put('2', board2);

        char[] board3 = {'d', 'e', 'f'};
        map.put('3', board3);

        char[] board4 = {'g', 'h', 'i'};
        map.put('4', board4);

        char[] board5 = {'j', 'k', 'l'};
        map.put('5', board5);

        char[] board6 = {'m', 'n', 'o'};
        map.put('6', board6);

        char[] board7 = {'p', 'q', 'r', 's'};
        map.put('7', board7);

        char[] board8 = {'t', 'u', 'v'};
        map.put('8', board8);

        char[] board9 = {'w', 'x', 'y', 'z'};
        map.put('9', board9);
    }
}
