package org.alg.algorithm.jack.第二周;

public class Q90004jieyushui {
    public int trap(int[] height){
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
   }
}
/**
 * 解法三: 动态规划
 * 我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
 *
 * 首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
 *
 * 对于 max_left我们其实可以这样求。
 *
 * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
 *
 * 对于 max_right我们可以这样求。
 *
 * max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
 *
 * 这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
 *
 * Java
 *
 * public int trap(int[] height) {
 *     int sum = 0;
 *     int[] max_left = new int[height.length];
 *     int[] max_right = new int[height.length];
 *
 *     for (int i = 1; i < height.length - 1; i++) {
 *         max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
 *     }
 *     for (int i = height.length - 2; i >= 0; i--) {
 *         max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
 *     }
 *     for (int i = 1; i < height.length - 1; i++) {
 *         int min = Math.min(max_left[i], max_right[i]);
 *         if (min > height[i]) {
 *             sum = sum + (min - height[i]);
 *         }
 *     }
 *     return sum;
 * }
 * 时间复杂度：O(n)O(n)。
 *
 * 空间复杂度：O(n)O(n)，用来保存每一列左边最高的墙和右边最高的墙。
 *
 * 解法四：双指针
 * 动态规划中，我们常常可以对空间复杂度进行进一步的优化。
 *
 * 例如这道题中，可以看到，max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，然后就再也不会用到了。所以我们可以不用数组，只用一个元素就行了。我们先改造下 max_left。
 *
 * Java
 *
 * public int trap(int[] height) {
 *     int sum = 0;
 *     int max_left = 0;
 *     int[] max_right = new int[height.length];
 *     for (int i = height.length - 2; i >= 0; i--) {
 *         max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
 *     }
 *     for (int i = 1; i < height.length - 1; i++) {
 *         max_left = Math.max(max_left, height[i - 1]);
 *         int min = Math.min(max_left, max_right[i]);
 *         if (min > height[i]) {
 *             sum = sum + (min - height[i]);
 *         }
 *     }
 *     return sum;
 * }
 * 我们成功将 max_left 数组去掉了。但是会发现我们不能同时把 max_right 的数组去掉，因为最后的 for 循环是从左到右遍历的，而 max_right 的更新是从右向左的。
 *
 * 所以这里要用到两个指针，left 和 right，从两个方向去遍历。
 *
 * 那么什么时候从左到右，什么时候从右到左呢？根据下边的代码的更新规则，我们可以知道
 *
 * Java
 *
 * max_left = Math.max(max_left, height[i - 1]);
 * height [ left - 1] 是可能成为 max_left 的变量， 同理，height [ right + 1 ] 是可能成为 right_max 的变量。
 *
 * 只要保证 height [ left - 1 ] < height [ right + 1 ] ，那么 max_left 就一定小于 max_right。
 *
 * 因为 max_left 是由 height [ left - 1] 更新过来的，而 height [ left - 1 ] 是小于 height [ right + 1] 的，而 height [ right + 1 ] 会更新 max_right，所以间接的得出 max_left 一定小于 max_right。
 *
 * 反之，我们就从右到左更。
 *
 * Java
 *
 * public int trap(int[] height) {
 *     int sum = 0;
 *     int max_left = 0;
 *     int max_right = 0;
 *     int left = 1;
 *     int right = height.length - 2; // 加右指针进去
 *     for (int i = 1; i < height.length - 1; i++) {
 *         //从左到右更
 *         if (height[left - 1] < height[right + 1]) {
 *             max_left = Math.max(max_left, height[left - 1]);
 *             int min = max_left;
 *             if (min > height[left]) {
 *                 sum = sum + (min - height[left]);
 *             }
 *             left++;
 *         //从右到左更
 *         } else {
 *             max_right = Math.max(max_right, height[right + 1]);
 *             int min = max_right;
 *             if (min > height[right]) {
 *                 sum = sum + (min - height[right]);
 *             }
 *             right--;
 *         }
 *     }
 *     return sum;
 * }
 * 时间复杂度： O(n)O(n)。
 *
 * 空间复杂度： O(1)O(1)。
 *
 *
 *
 * 作者：windliang
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
