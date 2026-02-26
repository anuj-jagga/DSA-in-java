class Solution {
    // formula = no. of subarray (exactly k) = no.of subarray(<=k) - no. of subarray(<= k-1)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return fun(nums,k) - fun(nums,k-1);
    }

    int fun(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int l = 0;
        int cnt = 0;
        for(int r=0; r < nums.length; r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.size() > k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }

            cnt += r-l+1;
        }
        return cnt;
    }
}