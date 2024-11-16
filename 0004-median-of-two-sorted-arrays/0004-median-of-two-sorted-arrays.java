class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int Len=m+n;
        int[] nums3=new int[Len];
        int cnt=0,v1,v2;

        for(int i=0;i<m;i++)
            nums3[cnt++]=nums1[i];
        for(int i=0;i<n;i++)
            nums3[cnt++]=nums2[i];

        Arrays.sort(nums3);
        if(Len%2==1)
          {
             v1=(nums3.length/2);
             return nums3[v1];
          }
        else
        {
            v1=(nums3.length/2);
            v2=v1-1;
            return ((nums3[v1]+nums3[v2])/2.0);
        }
    }
}