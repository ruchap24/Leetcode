class Solution {
    public String mergeAlternately(String word1, String word2) {
        char arr1[] = word1.toCharArray();
        char arr2[] = word2.toCharArray();
        int min = Math.min(arr1.length, arr2.length);

        char arr[] = new char[arr1.length + arr2.length];
        int sp = 0;
        for (int i = 0; i < min; i++) {
            arr[sp++] = arr1[i];
            arr[sp++] = arr2[i];
        }
        if (arr1.length > min) {
            for (int i = min; i < arr1.length; i++) {
                arr[sp++] = arr1[i];
            }
        } else if (arr2.length > min) {
            for (int i = min; i < arr2.length; i++) {
                arr[sp++] = arr2[i];
            }
        }
        return new String(arr);
    }
}


// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder result = new StringBuilder();
//         int i = 0;
//         while (i < word1.length() || i < word2.length()) {
//             if (i < word1.length()) {
//                 result.append(word1.charAt(i));
//             }
//             if (i < word2.length()) {
//                 result.append(word2.charAt(i));
//             }
//             i++;
//         }
//         return result.toString();
//     }
// } 
// O(n)