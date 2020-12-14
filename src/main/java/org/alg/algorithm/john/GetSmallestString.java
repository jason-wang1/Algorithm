package org.alg.algorithm.john;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * ClassName GetSmallestString
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 *
 * leetcode 1663. 具有给定数值的最小字符串
 * Date 12/9/20 10:38 PM
 */
public class GetSmallestString {


        public String getSmallestString(int n, int k) {
            if(n==0 || n*26<k){
                return  null;
            }
            int[] idx=new int[n];
//            初始赋值都为1
            for(int i=0;i<n;i++){
                idx[i]=1;
                k--;
            }
//            默认前n-1都是1，然后从后往前补26

            if(k<=n+24){
                idx[n-1]=k+1;
            }else {
                while (k > 26 + n - 1) {
                    idx[n - 1] = 26;
                    n = n - 1;
                    k = k - 25;
                }
                idx[n-1]=k+1;
            }
            String res = Arrays.stream(idx)
                    .boxed()
                    .map(i -> (char)('a' + i - 1) + "")
                    .collect(Collectors.joining());
            return  res;

    }
    @Test
    public void test(){
//        a-z 97-122
//        System.out.println('a'+1);

        String res = Arrays.stream(new int[]{1,2,6})
                .boxed()
                .map(i -> (char)('a' + i - 1) + "")
                .collect(Collectors.joining());
//        System.out.println(res);

        GetSmallestString gss = new GetSmallestString();
        String smallestString = gss.getSmallestString(4, 28);
        System.out.println(smallestString);

    }
}
