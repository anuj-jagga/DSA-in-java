class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n][amount+1];
        int minCoins = rec(n-1,amount,coins);
        return minCoins== 1e9? -1 : minCoins;
    }

    int rec(int i,int amount,int[] coins){
        if(amount == 0) return 0;
        if(i==0){
            if(amount % coins[0] == 0) return amount/coins[0];
            return (int)1e9;
        }

        if(dp[i][amount]!=null)  return dp[i][amount];
        int take =  (int)1e9;
        if(amount >= coins[i]){
            take = 1 + rec(i,amount-coins[i],coins);
        }
        int nottake = rec(i-1,amount,coins);

        return dp[i][amount] = Math.min(take,nottake);
    }
}