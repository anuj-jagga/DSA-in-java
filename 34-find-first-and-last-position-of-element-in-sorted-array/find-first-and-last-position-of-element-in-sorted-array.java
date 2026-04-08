class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int inbound = fun1(nums,target);
        if(inbound==-1 ) return new int[]{-1,-1};
        int outbound = fun2(nums,target);
        if(outbound == -1) return new int[]{inbound,n-1};
        return new int[]{inbound,outbound-1};
    }

    int fun1(int[] nums, int target){
        int s = 0, e = nums.length-1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                e = mid-1;
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;
    }

    int fun2(int[] nums, int target){
        int s=0, e = nums.length-1;
        int ans = -1;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                s = mid+1;
            }
            else if(nums[mid] > target){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }

        return ans;
    }
}