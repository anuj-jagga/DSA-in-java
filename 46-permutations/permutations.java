class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(0,nums, new ArrayList<Integer>());
        return res;
    }

    void backtrack(int idx,int[] nums,ArrayList<Integer> temp){
        int n = nums.length;
        if(idx == n){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<n; i++){
            swap(idx,i,nums);
            temp.add(nums[idx]);
            backtrack(idx+1,nums,temp);
            temp.remove(temp.size()-1);
            swap(idx,i,nums);
            
        }
    }

    void swap(int i,int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}