class Solution {
    Integer dp[];
    public int minCut(String s) {
        dp = new Integer[s.length()];
        return rec(0,s)-1;
    }

    int rec(int idx, String s){
        if(idx == s.length()) return 0;
        if(dp[idx]!=null) return dp[idx];
        int ans = Integer.MAX_VALUE;
        for(int i=idx; i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                int temp = 1 + rec(i+1,s);
                ans = Math.min(ans,temp);
            }
        }
        return dp[idx] = ans;
    }

    boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;

    }
}
