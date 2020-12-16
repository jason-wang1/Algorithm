package org.alg.algorithm.jack.第二周;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 * 示例 1：
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 方法二：组合计数
 */
public class Q7GoodNums {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map =new HashMap<Integer, Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int total=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int v=entry.getValue();
            total+=v*(v-1)/2;
        }
        return total;

    }
}
