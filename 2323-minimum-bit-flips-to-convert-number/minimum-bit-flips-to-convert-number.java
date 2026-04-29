class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        return cntSetBits(num);
    }

     public int cntSetBits(int n) {
        int cnt = 0;
        while(n!=0){
            n = n & (n-1); //  n & (n-1) turns off right most set bit
            cnt++;
        }
        return cnt;
    }
}