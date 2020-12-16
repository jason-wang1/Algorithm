package org.alg.algorithm.jack.第三周;



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q90007bnf {

        public List<List<Integer>> levelOrder(TreeNod root) {
            if(root==null) return new LinkedList<List<Integer>>();
            Queue<TreeNod> list=new LinkedList<TreeNod>();
            List<List<Integer>> result=new LinkedList<List<Integer>>();
            list.add(root);
            while(!list.isEmpty()){
                List<Integer> st=new LinkedList<Integer>();
                int size=list.size();
                for(int i=0;i<size;i++){
                    TreeNod tmp=list.poll();
                    if(tmp!=null)st.add(tmp.val);
                    if(tmp.left!=null){
                        list.add(tmp.left);
                    }
                    if(tmp.right!=null){
                        list.add(tmp.right);
                    }
                }
                if(st!=null&&st.size()!=0){
                    result.add(st);
                }
            }
            return result;
        }

}
class TreeNod {
    int val;
    TreeNod left;
    TreeNod right;
    TreeNod(int x) { val = x; }
}

