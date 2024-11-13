class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        int left=0;
        int sum_window = nums[0];
        for(int right=1;right<nums.length;right++){
            sum_window+=nums[right];
            int operations_needed = (nums[right]*(right-left+1))-sum_window;
            if(operations_needed<0) operations_needed=Integer.MAX_VALUE;
            if(operations_needed>k){
                sum_window-=nums[left++];
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}