class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[i]>0 && nums[i]<n && nums[i] != nums[correct]){
                swap(i,correct,nums);
            }else{
                i++;
            }
        }

        for(i=0; i<n; i++){
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }

    void swap(int i,int j,int[] arr){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j]=t;
    }
}