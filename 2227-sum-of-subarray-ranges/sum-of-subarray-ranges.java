class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    long sumSubarrayMins(int[] arr) {
        int[] prevSmaller = prevSmall(arr);
        int[] nextSmaller = nextSmall(arr);

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            ans += left * right * arr[i];
        }

        return ans;
    }

    long sumSubarrayMaxs(int[] arr) {
        int[] prevGreater = prevGreat(arr);
        int[] nextGreater = nextGreat(arr);

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - prevGreater[i];
            long right = nextGreater[i] - i;
            ans += left * right * arr[i];
        }

        return ans;
    }

    int[] prevSmall(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    int[] nextSmall(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    int[] prevGreat(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }

    int[] nextGreat(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return res;
    }
}