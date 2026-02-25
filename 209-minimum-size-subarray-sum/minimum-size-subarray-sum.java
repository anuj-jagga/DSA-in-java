class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int totSum = 0;
        for(int num:nums){
            totSum += num;
        }
        if(target > totSum) return 0;

        int windowSum  = 0;
        // int preSum = 0;
        int l = 0;
        int minLen = Integer.MAX_VALUE;;
        for(int r = 0; r < nums.length; r++){
            // preSum += nums[r];
            windowSum += nums[r];

            while(windowSum >= target){
                minLen = Math.min(minLen,r-l+1);
                windowSum -= nums[l];
                l++;
            }
        }

        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}