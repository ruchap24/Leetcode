class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {        
        int n=nums.length;
        if(n==1) { return 0; }
        long cnt=0;
        Arrays.sort(nums);
        int num=0;
        int low=0, high=0;
        for(int k=0; k<n; k++){    
            low=0; high=0;
            if( (k+1)<n && (nums[k]+nums[k+1])>upper ){
                return cnt;
            } 
            else if( nums[k]+nums[n-1]<lower ){
                continue;
            }
            low=binSearchLeft(nums, k+1, n-1, lower-nums[k]);         
            high=binSearchRight(nums, k+1, n-1, upper-nums[k]);      
            
            if(low>k && high>=low){
                cnt += high-low+1;
            }
        }
        return cnt; 
    }
    int binSearchLeft(int[] nums, int left, int right, int target){
        int mid=0, result=-1;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]>=target){
                result=mid;
                right=mid-1;                
            }
            else{
                left=mid+1;
            }
        }
        return result;
    }
   int binSearchRight(int[] nums, int left, int right, int target){
        int mid=0, result=-1;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]<=target){
                result=mid;
                left=mid+1;                
            }
            else{
                right=mid-1;
            }
        }
        return result;
    }
}