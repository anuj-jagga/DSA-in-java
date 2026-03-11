class Solution {
    List<List<Integer>> res;

    void backtrack(int idx, int[] nums, ArrayList<Integer> temp){
        int n = nums.length;
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=idx; i< n; i++){
            if(set.contains(nums[i])){
                continue;
            }

            set.add(nums[i]);
            swap(idx,i,nums);
            temp.add(nums[idx]);
            backtrack(idx+1,nums,temp);
            temp.remove(temp.size()-1);
            swap(idx,i,nums);
        }
    }

    void swap(int i,int j, int[] a){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<Integer>());
        return res;
    }
}