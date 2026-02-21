class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n+m];

        int i = 0, j = 0;
        int k = 0;

        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<n){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k] = nums2[j];
            k++;
            j++;
        }

        int len = arr.length;
        int idx = len/2;
        if(len%2 == 0){
            double med = (double) (arr[idx] + arr[idx-1]) / 2;
            return med;
        }
        double med = (double) arr[idx] ;
        return med;
    }
}