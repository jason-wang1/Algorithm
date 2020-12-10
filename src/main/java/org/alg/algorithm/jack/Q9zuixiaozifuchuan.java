package org.alg.algorithm.jack;

/**
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 *
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 *
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 *
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 *
 * x 是 y 的一个前缀；
 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 * 示例 1：
 *
 * 输入：n = 3, k = 27
 * 输出："aay"
 * 解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q9zuixiaozifuchuan {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int i = n;
        int m = k;
        char[] ch = new char[27];
        ch[1] = 'a';
        ch[2] = 'b';
        ch[3] = 'c';
        ch[4] = 'd';
        ch[5] = 'e';
        ch[6] = 'f';
        ch[7] = 'g';
        ch[8] = 'h';
        ch[9] = 'i';
        ch[10] = 'j';
        ch[11] = 'k';
        ch[12] = 'l';
        ch[13] = 'm';
        ch[14] = 'n';
        ch[15] = 'o';
        ch[16] = 'p';
        ch[17] = 'q';
        ch[18] = 'r';
        ch[19] = 's';
        ch[20] = 't';
        ch[21] = 'u';
        ch[22] = 'v';
        ch[23] = 'w';
        ch[24] = 'x';
        ch[25] = 'y';
        ch[26] = 'z';

        while (i > 0) {
            int h = Math.min(m - i + 1, 26);
            sb.append(ch[h]);
            m -= h;
            i--;
        }
        return sb.reverse().toString();
    }
}