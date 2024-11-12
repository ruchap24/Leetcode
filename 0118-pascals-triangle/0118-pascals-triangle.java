class Solution {
    public List<Integer> row(int row)
    {
        long a=1;
        List<Integer> temp=new ArrayList<>();        
         temp.add(1);
        for(int i=1;i<row;i++)
        {
            a=a*(row-i);
            a=a/i;
            temp.add((int)a);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();    
        for(int i=1;i<=numRows;i++)
        {
            ans.add(row(i));
        }
        return ans;
        }
}