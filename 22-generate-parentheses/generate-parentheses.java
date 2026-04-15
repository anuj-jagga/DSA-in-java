class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack("",0,0,n);
        return res;
    }

    void backtrack(String s, int open, int close, int n){
        if(s.length() == 2*n){
            res.add(s);
        }

        if(open < n){
            backtrack(s+'(',open+1,close,n);
        }
        if(close < open){
            backtrack(s+')',open,close+1,n);
        }
    }     
}