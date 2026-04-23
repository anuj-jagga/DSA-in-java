class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(i,correct,nums);
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1) return nums[i];
        }

        return -1;

        
    }

    void swap(int i, int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}