class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] prevSmaller = prevSmall(arr);
        int[] nextSmaller = nextSmall(arr);

        int MOD = 1000000007;
        long ans = 0; 

        for(int i=0;i<arr.length;i++){
            int left = i - prevSmaller[i];
            int right = nextSmaller[i] - i;
            long contribution = (left * 1L * right * arr[i]) % MOD;
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }

     int[] prevSmall(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // stack
        
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
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){ // imp note for this Q - just check for > not >=
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }else{
                res[i] = n;
            }

            st.push(i);
        }
        return res;
    }
}