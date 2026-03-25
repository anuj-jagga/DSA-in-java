class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int maxLen = triangle.size();
        dp = new Integer[maxLen][maxLen];
        return rec(0,0,triangle);
    }

    int rec(int i,int j,List<List<Integer>> triangle){
        if(i==triangle.size()-1) return triangle.get(i).get(j);

        if(dp[i][j]!=null) return dp[i][j];

        int down = triangle.get(i).get(j) + rec(i+1,j,triangle);
        int diag = triangle.get(i).get(j) + rec(i+1,j+1,triangle);
        return dp[i][j] = Math.min(down,diag);
    }
}