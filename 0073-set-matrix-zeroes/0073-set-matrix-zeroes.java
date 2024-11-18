class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        Set<Integer> row0 = new HashSet<>(), col0 = new HashSet<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {row0.add(i); col0.add(j);}
        

        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix[0].length; j++) {
                if (row0.contains(i)) matrix[i][j] = 0;
                if (col0.contains(j)) matrix[i][j] = 0;
            }
            
            
    }
}