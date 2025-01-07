// Optimised code 
// class Solution {
//     public String reverseWords(String s) {
//         int len = s.length();
//         int i = len - 1;

//         StringBuilder res = new StringBuilder();

//         while (i >= 0) {
//             // Skip trailing spaces
//             while (i >= 0 && s.charAt(i) == ' ') {
//                 i--;
//             }

//             // Find the start of the word
//             int j = i;
//             while (j >= 0 && s.charAt(j) != ' ') {
//                 j--;
//             }  // if we remove this while block then TLE will code......that's frustrating

//             // Add the word to the result
//             if (i > j) { // Only add if there's a valid word
//                 if (res.length() > 0) {
//                     res.append(' '); // Append a space between words
//                 }
//                 res.append(s.substring(j, i + 1));
//             }

//             i = j; // Move to the next word
//         }

//         return res.toString();
//     }
// }


// \s+ 

class Solution {
    public String reverseWords(String s) {
        String[] wordsArray = s.trim().split("\s+");
            List<String> wordsList = new ArrayList<String>(Arrays.asList(wordsArray));
            Collections.reverse(wordsList);
                String reversed = String.join(" ", wordsList);
                return reversed;
    }
}


// class Solution {
//     public String reverseWords(String s) {
//         String[] words=s.trim().split("\\s+");
//         String result=new String();
//         for(int i=words.length-1;i>=0;i--){
//             result+=words[i];
//             if(i!=0){
//                 result+=" ";
//             }
//         }
//         return result;
//     }
// }