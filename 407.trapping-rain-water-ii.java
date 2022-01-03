import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */

// @lc code=start
class Solution {
     public static class Pair implements Comparable<Pair>{
            int x;
            int y;
            int val;
        
            Pair(int x, int y,int val) {
              this.x = x;
              this.y = y;
              this.val=val;
            }

            public int compareTo(Pair k){
                return this.val-k.val;
            }
        
          }
    public int trapRainWater(int[][] arr) {
        boolean[][] v=new boolean[arr.length][arr[0].length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            v[i][0]=true;
            pq.add(new Pair(i,0,arr[i][0]));
            v[i][v[0].length-1]=true;
            pq.add(new Pair(i,v[0].length-1,arr[i][v[0].length-1]));
        }
        for(int i=1;i<arr[0].length-1;i++){
            v[0][i]=true;
            pq.add(new Pair(0,i,arr[0][i]));
            v[v.length-1][i]=true;
            pq.add(new Pair(v.length-1,i,arr[v.length-1][i]));
        }
        int ans=0;
        while(pq.size()>0){
            Pair r=pq.remove();

            v[r.x][r.y]=true;
            // if(r.x==r.y){
            //     continue;
            // }
            if(r.x+1<arr.length&&!v[r.x+1][r.y]){
               if(arr[r.x+1][r.y]<arr[r.x][r.y]){
                   ans+=arr[r.x][r.y]-arr[r.x+1][r.y];
                   arr[r.x+1][r.y]=arr[r.x][r.y];
                }
                pq.add(new Pair(r.x+1,r.y,arr[r.x+1][r.y]));
            }
            if(r.x-1>=0&&!v[r.x-1][r.y]){
                if(arr[r.x-1][r.y]<arr[r.x][r.y]){
                    ans+=arr[r.x][r.y]-arr[r.x-1][r.y];
                    arr[r.x-1][r.y]=arr[r.x][r.y];
                }
                pq.add(new Pair(r.x-1,r.y,arr[r.x-1][r.y]));
            }
            if(r.y+1<arr[0].length&&!v[r.x][r.y+1]){
                if(arr[r.x][r.y+1]<arr[r.x][r.y]){
                    ans+=arr[r.x][r.y]-arr[r.x][r.y+1];
                    arr[r.x][r.y+1]=arr[r.x][r.y];
                }
                pq.add(new Pair(r.x,r.y+1,arr[r.x][r.y+1]));
            }
            if(r.y-1>=0&&!v[r.x][r.y-1]){
                if(arr[r.x][r.y-1]<arr[r.x][r.y]){
                    ans+=arr[r.x][r.y]-arr[r.x][r.y-1];
                    arr[r.x][r.y-1]=arr[r.x][r.y];
                }
                pq.add(new Pair(r.x,r.y-1,arr[r.x][r.y-1]));
            }

        }
        return ans;
    }
}
// @lc code=end

