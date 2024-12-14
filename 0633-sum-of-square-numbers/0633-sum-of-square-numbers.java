class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);  // c<=2^31-1
        while (a <= b) {
            if (a * a + b * b == c) return true;
            else if (a * a + b * b > c) b--;
            else a++;
        }
        return false;
    }
}

//fermat's theorem