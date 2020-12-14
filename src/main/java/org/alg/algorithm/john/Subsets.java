package org.alg.algorithm.john;

import java.util.*;

/**
 * ClassName Subsets
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/12/20 12:36 AM
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();

        for(int i =0;i<nums.length;i++){
            hashSet.add(nums[i]);

        }
        Iterator<Integer> iter = hashSet.iterator();
        ArrayList<Integer> num = new ArrayList<>();
        while (iter.hasNext()){
            num.add(iter.next());
        }

        List<List<Integer>> res=new ArrayList<>();
//        List nothing = new ArrayList<Integer>(){};
//        res.add(nothing);

        for (int i =0;i<hashSet.size();i++){
            List<Integer> midList=new ArrayList<>();
//            midList.addAll()
           for(int j=hashSet.size()-1;j>=i;j--){
               Integer integer = num.get(j);
               midList.add(integer);

           }
            List<Integer> selfList= new ArrayList<>();
            selfList.add(num.get(i));
          res.add(selfList);
            res.add(midList);
        }
        return res;

    }
}
