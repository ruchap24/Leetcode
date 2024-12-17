class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> map=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character> list=new ArrayList<>();
        for(Character i : map.keySet()){
            list.add(i);
        }
        StringBuilder stb=new StringBuilder();
        while(!list.isEmpty()){
            char ch = list.get(0);
            int val=map.get(ch);
            if(val>=repeatLimit){
                for(int i=0;i<repeatLimit;i++){
                    stb.append(ch);
                }
                map.put(ch,val-repeatLimit);
                if(map.get(ch)==0){
                    map.remove(ch);
                    list.remove(0);
                }
                else{
                    if(list.size()>1){
                        char ch2=list.get(1);
                        stb.append(ch2);
                        map.put(ch2,map.get(ch2)-1);
                        if(map.get(ch2)==0){
                            map.remove(ch2);
                            list.remove(1);
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                for(int i=0;i<val;i++){
                    stb.append(ch);
                }
                map.remove(ch);
                list.remove(0);
            }
        }
        return stb.toString();
    }
}