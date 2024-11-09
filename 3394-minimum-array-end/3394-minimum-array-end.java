class Solution {
    public long minEnd(int n, int x) {
        long ans = x;

        n--;
        List<Integer> arr = new ArrayList<>();
        while(n != 0){
            arr.add(n % 2);
            n /= 2;
        }
        
        int idx = 0;
        for(int i = 0; i < 64 && idx < arr.size();i++){
            if(i < 32 && ((1 << i) & ans) != 0) continue; 
        
            if(arr.get(idx) == 1) ans += (long) Math.pow(2, i);
            System.out.println(ans);
            idx++;
        }
        return ans;
    }
}