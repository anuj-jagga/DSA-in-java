class Solution {
    Boolean[][] dp;
    public int countSubstrings(String s) {
        dp = new Boolean[1001][1001];
        int cnt = 0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(i,j,s)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean isPalindrome(int i, int j, String s) {
    if (i >= j) {
        return true; 
    }

    if (dp[i][j] != null) {
        return dp[i][j]; 
    }

    if (s.charAt(i) == s.charAt(j)) {
        dp[i][j] = isPalindrome(i + 1, j - 1, s);
    } else {
        dp[i][j] = false;
    }

    return dp[i][j];
   }
}