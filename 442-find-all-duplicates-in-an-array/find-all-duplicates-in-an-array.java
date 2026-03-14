class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // cycle sort technique
        int n = nums.length;
        int i=0;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[correct] != nums[i]){
                swap(i,correct,nums);
            }else{
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int idx=0; idx<n;idx++){
            if(nums[idx]!=idx+1) res.add(nums[idx]);
        }
        return res;
    }

    void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}