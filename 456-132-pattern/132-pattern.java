class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int third = Integer.MIN_VALUE;

        for(int i=nums.length-1;i>=0;i--){
            if(third > nums[i]) return true; // this will check for first
            while(!st.isEmpty() && nums[i] > st.peek()){ // this will ensure that 2nd > third
                third = st.pop();  
            }

            st.push(nums[i]);
        }

        return false;
    }
}