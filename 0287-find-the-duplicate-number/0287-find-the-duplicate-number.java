class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        int ptr = nums[0];
        while(ptr != slow) {
            slow = nums[slow];
            ptr = nums[ptr];
        }
        return ptr;
    }
}
