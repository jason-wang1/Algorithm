package org.alg.algorithm.jason.week6;

import java.util.HashMap;

/**
 * Descreption: 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Date: 2021年01月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q01LongestSubChars {
    public static void main(String args[]){
        String str = "bbaaacbd";
        System.out.println(new Q01LongestSubChars().longestSubstring(str, 3));
    }

    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];
        //  统计该字串每个字符出现频次
        for (int i = p1; i <= p2; ++i) {
            ++times[chars[i] - 'a'];
        }
        //  如果该字符出现频次小于k，则不可能出现在结果子串中
        //  分别排除，然后挪动两个指针
        while (p1 < p2 && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p1 < p2 && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k) return 0;
        //  得到临时子串，再递归处理
        for (int i = p1; i <= p2; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }

    /**
     * 暴力法，超出时间限制
     */
    public int longestSubstring2(String s, int k) {
        int res = 0;
        boolean flag;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length()-i < res){
                break;
            }
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                flag = true;
                for (Character character : map.keySet()) {
                    if (map.get(character) < k){
                        flag = false;
                        break;
                    }
                }
                if (flag && j-i+1 > res){
                    res = j-i+1;
                }
            }
            map.clear();
        }
        return res;
    }

}
