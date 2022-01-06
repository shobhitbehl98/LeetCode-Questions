import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> li=new ArrayList<>();
        List<List<Integer>> dl=new ArrayList<>();
        rec(li,dl,n,k,0);
        return dl;
    }

    public void rec(List<Integer> li,List<List<Integer>> dl,int n,int k,int i){
        if(li.size()==k){
            dl.add(new ArrayList<>(li));
            return;
        }
        for(int j=i+1;j<=n;j++){
           li.add(j); 
           rec(li,dl,n,k,j);
           li.remove(li.size()-1);
        }
    }
}
// @lc code=end

