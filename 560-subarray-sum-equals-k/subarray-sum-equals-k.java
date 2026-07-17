class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int preSum = 0;
        HashMap<Integer,Integer> preSumCount = new HashMap<>();
        preSumCount.put(0,1); // imp.
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            if(preSumCount.containsKey(preSum-k)){
                cnt += preSumCount.get(preSum-k);
            }
            
            preSumCount.put(preSum,preSumCount.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}