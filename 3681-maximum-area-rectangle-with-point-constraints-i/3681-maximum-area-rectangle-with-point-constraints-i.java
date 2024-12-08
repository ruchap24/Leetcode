class Solution {
    public int maxRectangleArea(int[][] points) {
        int maxArea = -1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 == x2 || y1 == y2) continue;

                if (isVRectangle(points, x1, y1, x2, y2)) {
                    int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private boolean isVRectangle(int[][] points, int x1, int y1, int x2, int y2) {
        boolean corner1 = false;
        boolean corner2 = false;
        int minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x == x1 && y == y2) {
                corner1 = true;
            }
            if (x == x2 && y == y1) {
                corner2 = true;
            }
            if ((x == x1 || x == x2) && (y > minY && y < maxY) || (y == y1 || y == y2) && (x > minX && x < maxX) || (y > minY && y < maxY && x > minX && x < maxX)) {
                return false;
            }
        }
        return corner1 && corner2;
    }
}