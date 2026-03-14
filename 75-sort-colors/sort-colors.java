class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length-1;

        while(mid <= end){
            if(nums[mid] == 2){
                swap(mid,end,nums);
                end--;
            }
            else if(nums[mid] == 0){
                swap(mid,start,nums);
                start++;
                mid++; //Because everything before mid is already processed.
            }else{
                mid++;
            }
        }
    }

    void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}