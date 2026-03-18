class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            res.add(fun(i));
        }
        return res;
    }

    List<Integer> fun(int row){
        List<Integer> temp = new ArrayList<>();
        int res = 1;
        temp.add(1);
        for(int col=2; col<=row; col++){
            res *= (row-col+1);
            res/= col-1;
            temp.add(res);
        }
        return temp;
    }
}