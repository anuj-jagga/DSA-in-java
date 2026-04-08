class Solution {
    // LIS variation
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int[] hash = new int[n];
        int lastIdx = 0;
        int max = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i]%nums[prev]==0 && dp[prev]+1 > dp[i]){
                    hash[i] = prev;
                    dp[i] = dp[prev] + 1;
                }
            }
            
            if(dp[i]> max){
                lastIdx = i;
                max = dp[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        while(hash[lastIdx]!=lastIdx){
            res.add(nums[lastIdx]);
            lastIdx = hash[lastIdx];
        }
        res.add(nums[lastIdx]);

        Collections.reverse(res);
        return res;
    }
}