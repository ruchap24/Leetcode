public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}  //O(n)



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


// O(n)
// class Solution {
//     public boolean checkIfExist(int[] arr) {
        
//         int len = arr.length;
//         HashSet<Integer> set = new HashSet<>();

//         for (int i = 0; i < len; i++) {

//             int curr = arr[i];

//             if (set.contains(2 * curr) || (curr % 2 == 0 && set.contains(curr / 2)))
//                 return true;
//             set.add(arr[i]);
//         }

//         return false;
//     }
// }

//O(n)
// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         List<Integer> l= new ArrayList<>();
//         Set<Integer> s= new HashSet<>();
//         for(int i: arr){
//             l.add(i);
//             s.add(i);
//         }
//         for(int i: s) {
//             if(i==0){
//                 if(Collections.frequency(l, 0)>1) return true;
//                 continue;
//             }
//             if(s.contains(i*2)) return true;
//         }
//         return false;
//     }
// }