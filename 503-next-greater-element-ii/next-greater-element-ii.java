class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        int idx = n-1;
        for(int i=2*n-1; i>=0; i--){

            if(i<=n-1){
                while(!st.isEmpty() && nums[i] >= st.peek()){
                    st.pop();
                }

                res[idx--] = st.isEmpty()? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }


        return res;
    }
}