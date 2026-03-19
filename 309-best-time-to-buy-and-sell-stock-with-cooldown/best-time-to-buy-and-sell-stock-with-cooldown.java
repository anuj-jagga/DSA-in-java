class Solution {
    static Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return rec(0,1,prices);
    }

    private static int rec(int i,int buy,int[] prices){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=null) return dp[i][buy];

        int profit = 0;

        if(buy==1){
            int take = -prices[i] + rec(i+1,0,prices);
            int nottake = rec(i+1,1,prices);
            profit = Math.max(take,nottake);
        }else{
            int sell = prices[i] + rec(i+2,1,prices);
            int notsell = rec(i+1,0,prices);
            profit = Math.max(sell,notsell);
        }
        return dp[i][buy] = profit;

    }
}