./*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<dp.length;i++){
            dp[i]=nums[i];
            if(dp[i-1]>=0){
                dp[i]+=dp[i-1];
            }
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
// @lc code=end

