class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int ans = 0;
        for(int[]a:boxTypes){
            if(truckSize == 0) break;

            if(truckSize >= a[0]){
                ans += a[0] * a[1];
                truckSize -= a[0];
            }else{
                ans += truckSize * a[1];
                truckSize = 0;
            }
        }
        return ans;
    }
}