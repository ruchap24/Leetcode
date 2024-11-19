class Solution {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        for(int i =0, j =nums.length-1; i<nums.length;i++){
            if(nums[i]==val){
                nums[i]= nums[j];
                nums[j]=-1;
                i--;
                j--;
                --length;
            }

        }
       
        return length;
    }
}