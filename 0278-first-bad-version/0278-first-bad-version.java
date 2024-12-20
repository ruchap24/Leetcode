/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// public class Solution extends VersionControl {
//     public int firstBadVersion(int n) {
//         int s=1, e=n;
//         while(s<e){
//             int m=s+(e-s)/2;
//         if(isBadVersion(m)){
//             e=m;
//            }
//         else{
//             s=m+1;
//            }
//         }
//         return s;
//     }
// }


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return recFirstBadVersion(1, n);
    }

    public int recFirstBadVersion(int b, int e) {
        if (b >= e)
            return b;

        int mid = b + (e - b) / 2;

        if (isBadVersion(mid))
            return recFirstBadVersion(b, mid);
        else
            return recFirstBadVersion(mid + 1, e);  
    }
}