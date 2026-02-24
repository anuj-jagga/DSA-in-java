class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }

        int left = 1;
        int right = max;
        // int k =0 ;
        while(left < right){
            int mid = left + (right-left)/2;
            if(calc(mid,piles) <= h){
                // k = mid;
                right = mid ;
            }
            if(calc(mid,piles) > h){
                left = mid + 1;
            }
        }
        return left;
    }

    long calc(int k,int[] piles){
        long hrs = 0;
        for(int i=0; i<piles.length;i++){
            hrs += piles[i]/k;
            if(piles[i]%k>0){
                hrs += 1;
            }
        }
        return hrs;
    }
}