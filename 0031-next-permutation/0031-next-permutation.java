class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        
        int i = len-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i==-1){
            Arrays.sort(nums);
            return;
        }
        int k = len-1;
        while(nums[k]<=nums[i]){
            k--;
        }
        swap(nums, i, k);
        
        int l;
        i+=1;
        for(l=len-1;l>i;l--){
            
            swap(nums, l, i);
            i++;
            
        }
    }
    
    void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
}