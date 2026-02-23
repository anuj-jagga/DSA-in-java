class Solution {
    Boolean[][] dp;
    public String longestPalindrome(String s) {
        dp = new Boolean[1001][1001];
        int n = s.length();
        int startIdx = 0;
        int maxLen=1;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    int len = j-i+1;
                    if(len > maxLen){
                        maxLen = len;
                        startIdx = i;
                    }
                }
            }
        }

        int endIdx = startIdx + maxLen - 1;
        return s.substring(startIdx,endIdx+1);
    }

    boolean isPalindrome(int i,int j,String s){
        if(i >= j) return true;
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = isPalindrome(i+1,j-1,s);
        }

        return dp[i][j] = false;
    }
}