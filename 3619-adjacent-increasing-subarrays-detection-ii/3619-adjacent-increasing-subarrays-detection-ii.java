class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int curr = 1;
        int prev = 0;
        int ans = 0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                curr++;
            }
            else{
                prev = curr;
                curr = 1;
            }
            ans = Math.max(ans,Math.max(curr/2,Math.min(prev,curr)));
        }
        return ans;
    }
}