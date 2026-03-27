class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return nums[0];

        if(n == 1) return k%2==0 ?  nums[0] : -1;

        if(k > n){
            int max = 0;
            for(int i : nums) max = Math.max(max,i);
            return max;
        }

        if(k == n){
            int max = 0;
            for(int i=0; i<n-1;i++){
                max = Math.max(max,nums[i]);
            }
            return max;
        }

        int max = 0;
        for(int i=0; i<k-1;i++){
            max = Math.max(nums[i],max);
        }
        return Math.max(max,nums[k]);
    }
}