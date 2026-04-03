class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n] ;// this indicates LIS ending at idx i
        return LIS(0,-1,nums);
    }

    int LIS(int i,int prev,int[] nums){
        if(i == nums.length) return 0;
        if(dp[i][prev+1] != null) return dp[i][prev+1];

        int take=0;
        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + LIS(i+1,i,nums);
        }
        int nottake = LIS(i+1,prev,nums);

        return dp[i][prev+1] = Math.max(take,nottake);
    }

}