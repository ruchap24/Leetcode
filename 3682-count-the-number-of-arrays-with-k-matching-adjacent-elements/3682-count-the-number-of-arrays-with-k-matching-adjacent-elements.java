class Solution
{
    public int countGoodArrays(int n, int m, int k)
    {
        final int MOD = 1_000_000_007;
        if (k < 0 || k > n - 1)
        {
            return 0;
        }
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
        {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        long[] invFact = new long[n];
        invFact[n - 1] = pow(factorial[n - 1], MOD - 2, MOD);
        for (int i = n - 2; i >= 0; i--)
        {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
        long combination = 0;
        if (k <= n - 1)
        {
            combination = factorial[n - 1] * invFact[k] % MOD * invFact[n - 1 - k] % MOD;
        }
        long power = 1;
        if (n - k - 1 >= 0)
        {
            power = pow(m - 1, n - k - 1, MOD);
        }
        long result = combination * m % MOD;
        result = result * power % MOD;

        return (int) result;
    }
    private long pow(long x, long y, long mod)
     {
        long res = 1;
        x %= mod;
        while (y > 0)
        {
            if ((y & 1) == 1) 
            {
                res = res * x % mod;
            }
            
            x = x * x % mod;
            y >>= 1;
        }
        
        return res;
    }
}
//T.C= O(n+log(m))  S.C=O(n)