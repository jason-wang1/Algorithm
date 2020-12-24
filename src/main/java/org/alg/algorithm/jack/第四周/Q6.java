package org.alg.algorithm.jack.第四周;

/**
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 *
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 *
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q6 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        //数组长度
        int m = nums1.length;
        int n = nums2.length;

        //dp[i][j]为nums1以索引 i 结尾、nums2以索引 j 结尾的最大点积
        int[][] dp = new int[m][n];

        //base case，初始值
        dp[0][0] = nums1[0] * nums2[0];

        //当nums1数组只有一个数时，依次计算出dp[0][i]的最大点积（即nums2中每个数与nums1[0]相乘，取最大值）
        for(int i = 1; i < n; ++i){
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }

        //当nums2数组只有一个数时，依次计算出dp[i][0]的最大点积（即nums1中每个数与nums2[0]相乘，取最大值）
        for(int i = 1; i < m; ++i){
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }

        //开始填充dp二维表格，对每行每列进行遍历
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                //dp[i][j]的最大值分为三种情况：
                // 不包含j dp[i][j-1]
                // 不包含i, dp[i-1][j]
                // 即包含i, 也包含j ，nums1[i] * nums2[j] 和 dp[i - 1][j - 1]
                // 因为dp[i - 1][j - 1]有可能是负数，如果为正数，就加（下面未注释的第2行），负数不加（下面未注释的第3行）
                // Math.max值能比较2个数，于是写成如下，dp[i][j]取这些情况的最大值即可
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], dp[i][j]);
                dp[i][j] = Math.max(nums1[i] * nums2[j], dp[i][j]);
            }
        }

        //返回结果
        return dp[m - 1][n - 1];
    }
}
