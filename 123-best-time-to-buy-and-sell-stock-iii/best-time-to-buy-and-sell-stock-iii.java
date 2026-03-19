class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][4]; // size 4 beacuase idx 0,2 means buy & 1,3 means sell 
        return rec(0,0,prices);
    }

    private int rec(int i,int transaction,int[] prices){
        if(transaction == 4 || i == prices.length) return 0;

        if(dp[i][transaction] != null) return dp[i][transaction];
        int profit = 0;
        if(transaction%2 == 0){
            int buy = -prices[i] + rec(i+1,transaction+1,prices);
            int notbuy = rec(i+1,transaction,prices);
            profit += Math.max(buy,notbuy);
        }
        else{
            int sell = prices[i] + rec(i+1,transaction+1,prices);
            int notsell = rec(i+1,transaction,prices);
            profit += Math.max(sell,notsell);
        }
        return dp[i][transaction] = profit;
    }
}