class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;;
        int l = 0;
        double sum = 0;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];
            if(r-l+1 == k){
                double avg = sum/k;
                ans = Math.max(ans,avg);
                sum -= nums[l];
                l++;
            }
        }
        return ans;
    }
}