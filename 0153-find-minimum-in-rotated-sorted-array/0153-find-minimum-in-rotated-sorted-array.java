class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++; 
                high--;
            } 
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } 
            else {
                high = mid; 
            }
        }

        return nums[low];
    }
}