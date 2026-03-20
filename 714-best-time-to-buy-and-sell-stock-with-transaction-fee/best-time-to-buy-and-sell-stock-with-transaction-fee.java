class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new Integer[n][2];
        return rec(0,1,prices,fee);
    }

    int rec(int i,int isBuy,int[] prices,int fee){
        if(i == prices.length) return 0;

        if(dp[i][isBuy] != null) return dp[i][isBuy];

        int profit = 0;
        if(isBuy == 1){
            int buy = - prices[i] + rec(i+1,0,prices,fee);
            int notbuy = rec(i+1,1,prices,fee);
            profit += Math.max(buy,notbuy);
        }
        else{
            int sell = prices[i] + rec(i+1,1,prices,fee) - fee;
            int notsell = rec(i+1,0,prices,fee);
            profit += Math.max(sell,notsell);
        }

        return dp[i][isBuy] = profit;
    }
}
