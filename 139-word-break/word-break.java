class Solution {
    Boolean dp[];
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];
        return rec(0,s,wordDict);
    }

    boolean rec(int idx, String s,List<String> wordDict){
        int n = s.length();
        if(idx == n) return true;
        if(dp[idx] != null) return dp[idx];
        if(set.contains(s)) return true;

        for(int end=idx+1; end<=n; end++){
            String temp = s.substring(idx,end);
            if(set.contains(temp) && rec(end,s,wordDict)){
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}