class Solution {
    public int maxSubArray(int[] nums) {
        // by kadane's algorithm
        int sum = 0, max = Integer.MIN_VALUE;

        for(int num:nums){ 
            sum = Math.max(num,sum+num);
            max=Math.max(sum,max);
        }
        return max;
    }
}