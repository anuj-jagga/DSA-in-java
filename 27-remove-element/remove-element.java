class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int ptr = 0;
        for(int n:nums){
            if(n!=val){
                k++;
                nums[ptr] = n;
                ptr++;
            }
        }
        return k;
    }
}