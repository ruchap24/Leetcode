// class Solution {
//     public boolean checkPerfectNumber(int n) {
//      if(num%2!=0 || num<5){
//             return false;
//         }
//         int sum=0;
//         for(int i=1;i<=n/2;i++){
//             if(n%i==0) sum+=i;
//         }
//         if(n==sum) return true;
//         return false;
//     }
// }


class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        
        int sum = 0;
        for(int i = 2; i <= num/i; i++) {  
            if(num % i == 0) {
                sum = sum + (num/i) + i;
            }
            System.out.println(sum);
        }
        if(sum + 1 == num) return true;
        return false;
    }
}



// class Solution {
//     public boolean checkPerfectNumber(int num) {
//         return (num==6 || num==28 || num==496 || num==8128 || num==33550336);
//     }
// }