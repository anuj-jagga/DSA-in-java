class Solution {
    // greedy will not work here.
    // rec + memo will give us TLE.

    // Optimal sol -
    // convert this problem into -
    // find max Length of subarray having sum = totalSum - x
    // return n - maxLength (no. of operations)

    // concept
    // prefix sum + mapping 

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totSum = 0;
        for(int num:nums){
            totSum += num;
        }

        int target = totSum - x;
        if (target < 0) return -1;
        if (target == 0) return n;

        int maxLen = -1; // 

        HashMap<Integer,Integer> map = new HashMap<>(); // it will store prefixSum as key and indices as value 
        map.put(0,-1); // important

        int preSum = 0;
        for(int i=0;i<n;i++){
            preSum += nums[i];

            if(map.containsKey(preSum - target)){
                maxLen= Math.max(maxLen, i - map.get(preSum - target)); // i - map.get(preSum - target is formula for finding length of subarray having sum = target
            }

            map.put(preSum,i);

        }

        if(maxLen == -1) return -1;

        int ops = n - maxLen;
        return ops;
    }
}