class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for(int i =0; i < nums.length; i++){
            int lowerBound = 0, upperBound = 0;
            lowerBound = bs(nums, lower-nums[i], i+1);
            upperBound = bs(nums, upper-nums[i]+1, i+1);
            res += upperBound -lowerBound;
        }
        return res;
    }
    public int bs(int[] nums, int target, int fixed){
        int l = fixed, r = nums.length;
        while(l < r){
            int mid = l + (r-l) / 2;
            if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r= mid;
            }
        }
        return l;
    } 
}