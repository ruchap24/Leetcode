// O(n^2)

// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j && arr[i]==2*arr[j]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean checkIfExist(int[] arr) {
        
        int len = arr.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {

            int curr = arr[i];

            if (set.contains(2 * curr) || (curr % 2 == 0 && set.contains(curr / 2)))
                return true;
            set.add(arr[i]);
        }

        return false;
    }
}