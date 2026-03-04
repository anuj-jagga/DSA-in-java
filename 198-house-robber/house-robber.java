class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(0,nums);
    }
    private static int rec(int i,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = Math.max(nums[i] + rec(i+2,nums),rec(i+1,nums));
    }
}