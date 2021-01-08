package org.alg.algorithm.jack.第六周;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class GuPiao {
    public int maxProfit1(int[] prices) {
        int len=prices.length;
        if(prices==null||len==0) return 0;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        dp[0] = 0;//手里现金
        dp[1] = -prices[0];//手里持有的股票
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);//手里现金加上卖出去的股票
            dp[1] = Math.max(dp[1], -prices[i]);//手里股票 又买股票
        }
        return dp[0];
    }


}

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 public int maxProfit(int[] arr) {
 if (arr == null || arr.length <= 1) return 0;

 int ans = 0;
 for (int i = 1; i < arr.length; i++) {
 if (arr[i] > arr[i-1]) {  // 卖出有利可图
 ans += (arr[i] - arr[i-1]);
 }
 }
 return ans;
 }

 方法二：动态规划（通用）
 根据 「力扣」第 121 题的思路，需要设置一个二维矩阵表示状态。

 第 1 步：定义状态
 状态 dp[i][j] 定义如下：

 dp[i][j] 表示到下标为 i 的这一天，持股状态为 j 时，我们手上拥有的最大现金数。

 注意：限定持股状态为 j 是为了方便推导状态转移方程，这样的做法满足 无后效性。

 其中：

 第一维 i 表示下标为 i 的那一天（ 具有前缀性质，即考虑了之前天数的交易 ）；
 第二维 j 表示下标为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票（stock）。
 第 2 步：思考状态转移方程
 状态从持有现金（cash）开始，到最后一天我们关心的状态依然是持有现金（cash）；
 每一天状态可以转移，也可以不动。状态转移用下图表示：


 （状态转移方程写在代码中）

 说明：

 由于不限制交易次数，除了最后一天，每一天的状态可能不变化，也可能转移；
 写代码的时候，可以不用对最后一天单独处理，输出最后一天，状态为 0 的时候的值即可。
 第 3 步：确定初始值
 起始的时候：

 如果什么都不做，dp[0][0] = 0；
 如果持有股票，当前拥有的现金数是当天股价的相反数，即 dp[0][1] = -prices[i]；
 第 4 步：确定输出值
 终止的时候，上面也分析了，输出 dp[len - 1][0]，因为一定有 dp[len - 1][0] > dp[len - 1][1]。

 参考代码 2：

 Java

 public class Solution {

 public int maxProfit(int[] prices) {
 int len = prices.length;
 if (len < 2) {
 return 0;
 }

 // 0：持有现金
 // 1：持有股票
 // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
 int[][] dp = new int[len][2];

 dp[0][0] = 0;
 dp[0][1] = -prices[0];

 for (int i = 1; i < len; i++) {
 // 这两行调换顺序也是可以的
 dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
 dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 }
 return dp[len - 1][0];
 }
 }


 作者：liweiwei1419
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 class Solution {
 public int maxProfit(int[] prices) {
 int n = prices.length;
 int[][] dp = new int[n][2];
 dp[0][0] = 0;
 dp[0][1] = -prices[0];
 for (int i = 1; i < n; ++i) {
 dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
 dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 }
 return dp[n - 1][0];
 }
 }


 */



