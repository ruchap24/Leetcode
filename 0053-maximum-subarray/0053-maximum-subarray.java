class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currSum=0;
        for(int start=0;start<nums.length;start++){
            currSum+=nums[start];
            maxSum = currSum>maxSum?currSum:maxSum;
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}