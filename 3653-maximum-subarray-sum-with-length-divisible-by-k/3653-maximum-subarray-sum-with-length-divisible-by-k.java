class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix[] = new long[n+1];
       
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        long maxSum =Long.MIN_VALUE;
        for(int group = 0;group<k;group++){
            long cSum = 0;
            for(int i=group;i+k<=n;i+=k){
                long groupSum = prefix[i+k] - prefix[i];
                cSum = Math.max(groupSum, cSum + groupSum);
                maxSum = Math.max(maxSum,cSum);
            }
        }
        return maxSum;
    }
}