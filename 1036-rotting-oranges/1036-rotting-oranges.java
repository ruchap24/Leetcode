class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int fo = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fo++;
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (fo == 0) return 0;
        
        int coun = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                vis[r][c] = 1;
                
                if (r + 1 < m && grid[r + 1][c] == 1 && vis[r + 1][c] != 1) {
                    q.add(new int[]{r + 1, c});
                    grid[r + 1][c] = 2;
                    fo--;
                    flag = 1;
                }
                
                if (r - 1 >= 0 && grid[r - 1][c] == 1 && vis[r - 1][c] != 1) {
                    q.add(new int[]{r - 1, c});
                    grid[r - 1][c] = 2;
                    fo--;
                    flag = 1;
                }
                
                if (c + 1 < n && grid[r][c + 1] == 1 && vis[r][c + 1] != 1) {
                    q.add(new int[]{r, c + 1});
                    grid[r][c + 1] = 2;
                    fo--;
                    flag = 1;
                }
                
                if (c - 1 >= 0 && grid[r][c - 1] == 1 && vis[r][c - 1] != 1) {
                    q.add(new int[]{r, c - 1});
                    grid[r][c - 1] = 2;
                    fo--;
                    flag = 1;
                }
            }
            
            if (flag == 1) {
                coun++;
            }
        }
        
        if (fo > 0) {
            return -1;
        }
        
        return coun;
    }
}