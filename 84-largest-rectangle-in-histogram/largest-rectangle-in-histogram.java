class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prevSmaller = prevSmall(heights);
        int[] nextSmaller = nextSmall(heights);
        int n = heights.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            if(nextSmaller[i] == -1){
                nextSmaller[i] = n;
            }

            ans = Math.max(ans, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }

        return ans;
    }

    int[] prevSmall(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }else{
                res[i] = -1;
            }

            st.push(i);
        }
        return res;
    }

    int[] nextSmall(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }else{
                res[i] = -1;
            }

            st.push(i);
        }
        return res;
    }
}