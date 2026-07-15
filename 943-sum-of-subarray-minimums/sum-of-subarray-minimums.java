class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        int[] prevSmall = prevSmaller(arr,n);
        int[] nextSmall = nextSmaller(arr,n);

        long total = 0;
        for(int i=0; i<n;i++){
            int left = i - prevSmall[i];
            int right = nextSmall[i] - i;
            long contribution = (left * 1L * arr[i] * right) % MOD;
            total = (total + contribution) % MOD;
        }

        return (int)total;
    }

    int[] prevSmaller(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=0; i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            res[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        return res;
    }

    int[] nextSmaller(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1; i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            res[i] = st.isEmpty()? n:st.peek();
            st.push(i);
        }

        return res;
    }
}