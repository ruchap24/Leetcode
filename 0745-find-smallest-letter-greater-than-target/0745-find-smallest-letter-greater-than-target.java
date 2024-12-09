//O(logn) -- binary search

class Solution {
    public char nextGreatestLetter(char[] letters, char target){
        int low=0, high=letters.length-1;
        char ans=letters[0];
        while(low<=high){
            int mid=low+high/2;
            if(letters[mid]>target){
                ans=letters[mid];
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
}



//O(n)

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         int n=letters.length;
//         if(letters[0]>target)
//         return letters[0];
//         for(int i=1;i<n;i++){
//             if(letters[i]>target)
//             return letters[i];
//         }
//         return letters[0];
//     }
// }