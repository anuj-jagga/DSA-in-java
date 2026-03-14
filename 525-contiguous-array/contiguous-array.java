class Solution {
    // compare this Q with LC 560 with target = 0
    // when you see 0 in arr, preSum -= 1;
    public int findMaxLength(int[] nums) {
        int preSum = 0;
        int maxLen= 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                preSum += -1;
            }else{
                preSum += 1;
            }

            if(map.containsKey(preSum)){ // it means after index (where you alr has this presum) to curr idx you subarray had sum 0(which is our target)
                maxLen = Math.max(maxLen,i - map.get(preSum));
            }else{
                map.put(preSum,i);
            }
        }
        return maxLen;
    }
}