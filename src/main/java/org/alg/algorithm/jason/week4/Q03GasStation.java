package org.alg.algorithm.jason.week4;

/**
 * Descreption: 加油站
 * https://leetcode-cn.com/problems/gas-station/
 *
 * Date: 2020年12月22日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q03GasStation {
    public static void main(String args[]){
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(new Q03GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }

        for (int i = 0; i < gas.length; i++) {
            int remain = 0;

            for (int j = i; j < gas.length; j++) {
                remain += gas[j];
                if (remain < 0)
                    break;
            }
            if (remain < 0)
                continue;

            for (int j = 0; j < i; j++) {
                remain += gas[j];
                if (remain < 0)
                    break;
            }
            if (remain >= 0)
                return i;
        }
        return -1;
    }
}
