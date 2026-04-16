class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<Integer>());
        return res;
    }

    void backtrack(int i, int[]nums,List temp){
        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        backtrack(i+1,nums,temp);
        temp.remove(temp.size()-1);

        while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        backtrack(i+1,nums,temp);
    }
}