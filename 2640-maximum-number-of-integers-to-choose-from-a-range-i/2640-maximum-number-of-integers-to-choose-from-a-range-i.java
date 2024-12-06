class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int res=0;
        int sum=0;
        int a[]=new int[100001];
        for(int i:banned)a[i]++;
        for(int i=1;i<=n;i++)
        {
            if(a[i]==0&&(i+sum)<=maxSum){
                res++;
                sum+=i;
            }
        }
        return res;   
    }
          
}