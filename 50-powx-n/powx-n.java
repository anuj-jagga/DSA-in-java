class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return power(x, N);
    }

    double power(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        if (n % 2 == 0) {
            return power(x * x, n / 2);
        } else {
            return x * power(x * x, n / 2);
        }
    }
}