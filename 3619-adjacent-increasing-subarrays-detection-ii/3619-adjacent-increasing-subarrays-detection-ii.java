class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prefixIncreasing[] = new int[nums.size()];

        prefixIncreasing[0] = 1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                prefixIncreasing[i] = prefixIncreasing[i-1]+1;
            }
            else{
                prefixIncreasing[i] = 1;
            }
        }

        int res = 1;
        for(int i=1;i<nums.size();i++){
            int k = prefixIncreasing[i];
            if(k>1 && i-k>=0 && prefixIncreasing[i-k]>=k){
                res = Math.max(res,k);
            }
            if(prefixIncreasing[i]%2==0){
                res = Math.max(res,prefixIncreasing[i]/2);
            }
        }
        return res;
    }
}