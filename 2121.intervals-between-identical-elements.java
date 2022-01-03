import java.util.HashSet;

/*
 * @lc app=leetcode id=2121 lang=java
 *
 * [2121] Intervals Between Identical Elements
 */

// @lc code=start
class Solution {
    public class Pair{
        long sum;
        long count;
        
        Pair(long sum,long count){
            this.sum=sum;
            this.count=count;
        }
    }
    public long[] getDistances(int[] arr) {
        long[] ans=new long[arr.length];
        Pair[] f=new Pair[arr.length];
        Pair[] b=new Pair[arr.length];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                f[i]=new Pair(0,1);
            }else{
                f[i]=new Pair(hm.get(arr[i])+f[hm.get(arr[i])].sum,f[hm.get(arr[i])].count+1);
            }  
            hm.put(arr[i],i);
        }
        hm=new HashMap<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!hm.containsKey(arr[i])){
                b[i]=new Pair(0,1);
            }else{
                b[i]=new Pair(hm.get(arr[i])+b[hm.get(arr[i])].sum,b[hm.get(arr[i])].count+1);
            }  
            hm.put(arr[i],i);
        }

        for(int i=0;i<arr.length;i++){
            ans[i]=(i*f[i].count-(f[i].sum))+(b[i].sum-(i*b[i].count));
        }

        return ans;

        
    }
}
// @lc code=end

