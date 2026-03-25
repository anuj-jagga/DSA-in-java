class Solution {
    // Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        
        int[][] dp = new int[n+2][n+2];

        for(int i=n;i>=1;i--){
            for(int j=1; j<=n;j++){
                if(i>j) continue;
                int ans = 0;
                for(int k=i; k<=j; k++){
                    int cost = dp[i][k-1] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j+1];
                    ans = Math.max(ans,cost);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];

        // return mcm(arr,1,n);
    }

    // int mcm(int[]arr,int i,int j){
    //     if(i>j) return 0; //variation to mcm
    //     if(dp[i][j]!=null) return dp[i][j];
    //     int ans = 0;
    //     for(int k=i;k<=j;k++){
    //         int c1 = mcm(arr,i,k-1); // current vala baloon fod diya thats why k-1
    //         int c2 = mcm(arr,k+1,j);
    //         int c3 = arr[i-1] * arr[k] * arr[j+1];
    //         int tc = c1+c2+c3;
    //         ans = dp[i][j] = Math.max(tc,ans);
    //     }
    //     return ans;
    // }
}