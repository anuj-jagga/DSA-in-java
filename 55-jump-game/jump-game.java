class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return rec(0, nums);
    }

    boolean rec(int i,int[] nums){
        int n=nums.length;
        if(i == n-1) return true;
        if(nums[i]==0) return false;
        if(dp[i]!=null) return dp[i];
        for(int j=1;j<=nums[i];j++){
            if(i+j>=n) break;
            if(rec(i+j,nums)) return true;
        }
        
        return dp[i] = false;
    }
}