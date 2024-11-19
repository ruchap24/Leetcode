class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        find(nums,0);
        return al;
    }
    public void find(int[] nums,int i){
        if(i==nums.length){
            List<Integer> l=new ArrayList<>();
            for(int k=0;k<nums.length;k++)
            l.add(nums[k]);
            al.add(l);
            return;
        }
        for(int j=i;j<nums.length;j++){
            //first swap
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            find(nums,i+1);
            //second swap
            t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
        return;
    }
}