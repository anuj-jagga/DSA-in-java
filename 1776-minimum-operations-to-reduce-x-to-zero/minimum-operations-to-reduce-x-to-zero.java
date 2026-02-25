class Solution {
    // greedy will not work here.
    // rec + memo will give us TLE.

    // Optimal sol -
    // convert this problem into -
    // find max Length of subarray having sum = totalSum - x
    // return n - maxLength (no. of operations)

    // concept
    // Sliding Window
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totSum = 0;
        for(int num:nums){
            totSum += num;
        }

        int target = totSum - x;
        int windowSum = 0;
        int maxLen = -1;
        int l=0;
        for(int r=0;r<n;r++){
            windowSum += nums[r];

            while(l<=r && windowSum > target){
                windowSum -= nums[l];
                l++;
            }
            if(windowSum == target){
                maxLen = Math.max(maxLen , r-l+1);
            }
        }

        if(maxLen == -1) return -1;
        int ops = n-maxLen;
        return ops;
    }
}