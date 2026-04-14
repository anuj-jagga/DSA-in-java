class Solution {
    public int maximalRectangle(char[][] matrix) {
        // apply largest rectangle in histogram concept at each row

        int n = matrix.length;
        int m = matrix[0].length;
        int[] col = new int[m];
        int ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m;j++){
                if(matrix[i][j] == '0'){
                    col[j] = 0;
                }else{
                    col[j] += 1;
                }
            }

            ans = Math.max(ans,largestRectangleArea(col));
        }
        return ans;
    }

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