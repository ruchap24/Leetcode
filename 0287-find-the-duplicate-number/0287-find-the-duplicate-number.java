class Solution {
    public int findDuplicate(int[] nums) {
        boolean contain[] = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(contain[nums[i]-1] == true){
                return nums[i];
            }
            contain[nums[i]-1] = true;
        }
        return 0;    
    }
}