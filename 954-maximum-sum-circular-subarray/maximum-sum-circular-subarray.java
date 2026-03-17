class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int num:nums){
            sum = Math.max(num,num+sum);
            maxSum = Math.max(maxSum,sum);
        }

        int minSum = Integer.MAX_VALUE;
        sum = 0;

        int totSum = 0;
        for(int num:nums){
            totSum += num;
            sum = Math.min(num,num+sum);
            minSum = Math.min(minSum,sum);
        }

        if(maxSum > 0) return Math.max(maxSum,totSum - minSum); 
        return maxSum;
    }
}