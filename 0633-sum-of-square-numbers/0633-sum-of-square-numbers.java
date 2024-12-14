// class Solution {
//     public boolean judgeSquareSum(int c) {
//         long a = 0, b = (long) Math.sqrt(c);  // c<=2^31-1
//         while (a <= b) {
//             if (a * a + b * b == c) return true;
//             else if (a * a + b * b > c) b--;
//             else a++;
//         }
//         return false;
//     }
// }

//fermat's theorem states that a number can be represented as the sum of two squares if and only if all prime factors of the form ( 4k + 3 ) have even powers in its prime factorization.
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int divisor = 2; divisor * divisor <= c; divisor++) {
            if (c % divisor == 0) {
                int exponentCount = 0;
                while (c % divisor == 0) {
                    exponentCount++;
                    c /= divisor;
                }
                if (divisor % 4 == 3 && exponentCount % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }
}



// class Solution {
//     public boolean judgeSquareSum(int c) {
//         if (c%4==3) return false;

//         int i=2, j=(int)Math.sqrt(c);
//         while (i<=j){
//             if (c%i==0){
//                 c/=i;
//                 int cnt=1;
//                 while (c%i==0){
//                     cnt++;
//                     c/=i;
//                 }
//                 if (i%4==3 && cnt%2!=0) return false;
//             }
//             i++;
//         }
//         return c%4!=3;
//     }
// }