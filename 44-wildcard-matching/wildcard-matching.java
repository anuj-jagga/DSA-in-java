class Solution {
    static Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        // treat p as s1 and s as s2
        int n = p.length();
        int m = s.length();
        dp = new Boolean[n][m];
        return rec(n-1,m-1,p,s);
    }

    boolean rec(int i,int j, String s1,String s2){
        if(i<0 && j<0) return true; 
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            if(isAllStars(i,s1)) return true;
            return false;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i)== '?'){
            return dp[i][j] = rec(i-1,j-1,s1,s2);
        }

        if(s1.charAt(i) == '*'){
            return dp[i][j] = rec(i-1,j,s1,s2) || rec(i,j-1,s1,s2); // this will do every comparison possible
        }

        return dp[i][j] = false; // if(s1[i] != s2[j] && s2[j] != '*' or '?')
        
    }

    boolean isAllStars(int idx,String s){
        while(idx>=0){
            if(s.charAt(idx)!='*') return false;
            idx--;
        }
        return true;
    }
}