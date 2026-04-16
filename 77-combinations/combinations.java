class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<Integer>());
        return res;
    }

    void backtrack(int num, int n, int k,ArrayList<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=num;i<=n;i++){
            temp.add(i);
            backtrack(i+1,n,k,temp);
            temp.remove(temp.size()-1);
        }
    }
}