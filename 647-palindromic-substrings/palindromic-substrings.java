class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        for(int L=2; L<=n;L++){
            
            for(int i=0; i <= n-L;i++){
                int j = i+L-1;

                if(s.charAt(i) == s.charAt(j) && L==2){
                    dp[i][j] = true;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        
        int cnt = 0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(dp[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    
}