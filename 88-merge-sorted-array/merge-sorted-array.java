class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;           // last valid element in a
        int j = n - 1;           // last element in b
        int k = m + n - 1;       // last position in a

        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                a[k] = a[i];
                i--;
            } else {
                a[k] = b[j];
                j--;
            }
            k--;
        }

        while(j >= 0){
            a[k] = b[j];
            j--;
            k--;
        }
    }
}