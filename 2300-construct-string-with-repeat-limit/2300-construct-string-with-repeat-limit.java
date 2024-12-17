class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];

        for(char ch : s.toCharArray()) count[ch - 'a']++;

        int r = 24;
        StringBuilder sb = new StringBuilder();

        for(int i = 25; i >= 0 ; i--){
            r = Math.min(r, i - 1);
            while(count[i] != 0){
                int curr;
                if(count[i] > repeatLimit){
                    curr = repeatLimit;
                    while(curr-- > 0 ) sb.append((char)('a' + i));
                    while(r >= 0 && count[r] == 0) r--;
                    if(r < 0) return sb.toString();
                    sb.append((char)('a' + r));
                    count[r]--;
                    count[i] -= repeatLimit;
                }
                else{
                    curr = count[i];
                    while(curr-- > 0) sb.append((char)('a' + i));
                    count[i] = 0;
                }
            }
        }
        
        
        return sb.toString();
    }
}


// class Solution {
//     public String repeatLimitedString(String s, int repeatLimit) {
//         Map<Character,Integer> map=new TreeMap<>(Collections.reverseOrder());
//         for(int i=0;i<s.length();i++){
//             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//         }
//         List<Character> list=new ArrayList<>();
//         for(Character i : map.keySet()){
//             list.add(i);
//         }
//         StringBuilder stb=new StringBuilder();
//         while(!list.isEmpty()){
//             char ch = list.get(0);
//             int val=map.get(ch);
//             if(val>=repeatLimit){
//                 for(int i=0;i<repeatLimit;i++){
//                     stb.append(ch);
//                 }
//                 map.put(ch,val-repeatLimit);
//                 if(map.get(ch)==0){
//                     map.remove(ch);
//                     list.remove(0);
//                 }
//                 else{
//                     if(list.size()>1){
//                         char ch2=list.get(1);
//                         stb.append(ch2);
//                         map.put(ch2,map.get(ch2)-1);
//                         if(map.get(ch2)==0){
//                             map.remove(ch2);
//                             list.remove(1);
//                         }
//                     }
//                     else{
//                         break;
//                     }
//                 }
//             }
//             else{
//                 for(int i=0;i<val;i++){
//                     stb.append(ch);
//                 }
//                 map.remove(ch);
//                 list.remove(0);
//             }
//         }
//         return stb.toString();
//     }
// }