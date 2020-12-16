package org.alg.algorithm.john;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ClassName NumIdenticalPairs
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/8/20 8:38 PM
 */


public class NumIdenticalPairs {
    /**
     * 双循环暴力求解
     * 时间复杂度 O(n2)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        if (nums.length <= 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 基于HashMap的好数对
     * 如果k有一个，贡献度为0；k有2个，贡献度为1；k有3个贡献度为2；k有4个贡献度为6；
     * 规律是：v(v-1)/2
     * 将k值作为key，贡献值作为value写入map
     * 最终只需要遍历一次，就可以求解
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairsWithMap(int[] nums) {
        int res = 0;

        HashMap<Integer, Integer> intIntHashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int value = intIntHashMap.getOrDefault(nums[i], 0) + 1;
            intIntHashMap.put(nums[i], value);
        }
//        遍历map获取所有贡献度加和
        Set<Map.Entry<Integer, Integer>> entries = intIntHashMap.entrySet();
        Iterator<Integer> iter = intIntHashMap.values().iterator();
        while (iter.hasNext()) {
            int value = iter.next();
            res += value * (value - 1) / 2;
        }

        return res;
    }

    @Test
    public void test() {
        NumIdenticalPairs nit = new NumIdenticalPairs();
        int res = nit.numIdenticalPairsWithMap(new int[]{1, 2, 3, 1, 1, 3});
        System.out.println(res);


    }

//    public static void main(String[] args) {
//        NumIdenticalPairs nit = new NumIdenticalPairs();
//        int res = nit.numIdenticalPairs(new int[]{1,2,3,1,1,3});
//        System.out.println(res);
//    }

}
