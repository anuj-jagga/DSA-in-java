class Solution {
    // intuition : 
    // mantain monotonic decreasing order of stack
    // store only the indices that could possibly become the left side of the best ramp 
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(st.isEmpty() || nums[i] < nums[st.peek()]){
                st.push(i);
            }
        }

        int ans = 0;
        for(int j=nums.length-1;j>=0;j--){
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]){
                ans = Math.max(ans,j-st.peek());
                st.pop();
            }
        }

        return ans;
    }
}