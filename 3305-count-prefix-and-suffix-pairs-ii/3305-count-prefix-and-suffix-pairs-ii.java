class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        long k = 0;
        boolean str[] = new boolean[words.length];
        for(int i=0; i<words.length; i++){
            String s = words[i];
            if(str[i]) continue;
            long found = 1;
            for(int j=i+1; j<words.length; j++){
                String curr = words[j];
                if(curr.length() >= s.length() 
                   && s.equals(curr.substring(0,s.length())) 
                   && s.equals(curr.substring(curr.length() - s.length()))){
                    k+=found;
                }
                if(s.equals(curr)){ 
                    found++; 
                    str[j] = true;
                }

            }
        }
        return k;
    }
}



// class Solution {
//     public long countPrefixSuffixPairs(String[] words) {
//         long ans=0;
//         int n=words.length;
//         HashSet<String> set=new HashSet<>();
//         for(int i=0;i<n-1;i++){
//             if(!set.contains(words[i])){
//                 long sub=0;
//                 int k=words[i].length();
//                 for(int j=n-1;j>i;j--){
//                     int k2=words[j].length();
//                     if(k2>=k){
//                         if(words[j].equals(words[i]))
//                             ans+=sub;
//                         if(words[j].substring(0,k).equals(words[i]) && words[j].substring(k2-k).equals(words[i])){
//                             sub+=1;
//                         }
//                     }
//                 }
//                 ans+=sub;
//             }
//             set.add(words[i]);
//         }
//         return ans;
//     }
// }