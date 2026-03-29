class Solution {
    long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n+1)/2; // no. of even idx positions
        long odd = (n)/2; // no. of odd idx positons

        long ans = (pow(5,even) * pow(4,odd)) % MOD;
        return (int) ans;
    }

    long pow(long base, long exp){
        if(exp == 0) return 1;
        if(exp == 1) return base;

        long half = pow(base,exp/2);
        long res = (half * half)% MOD;
        if(exp%2!=0){
            return (base * res) % MOD;
        }

        return res;
    }
}