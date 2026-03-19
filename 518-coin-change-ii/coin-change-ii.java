class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp = new Integer[n][amount+1];
        return rec(n-1,amount,coins);
    }

    int rec(int i,int amount,int[] coins){
        if(i == 0){
            if(amount == 0) return 1;
            if(amount%coins[i] == 0) return 1; // take at index 0 only when this condition satisfies
            return 0;
        }

        if(dp[i][amount] != null) return dp[i][amount];

        int nottake = rec(i-1,amount,coins);

        int take = 0;
        if(amount >= coins[i]){
            take = rec(i,amount-coins[i],coins);
        }

        return dp[i][amount] = take + nottake;
    }
}