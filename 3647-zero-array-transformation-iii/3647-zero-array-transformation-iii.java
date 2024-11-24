class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        // Custom comparator for reverse order
        TreeSet<int[]> s1 = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });
        TreeSet<int[]> s2 = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });  
        // Maps to store query indices
        Map<Integer, List<Integer>> m1 = new HashMap<>();
        Map<Integer, List<Integer>> m2 = new HashMap<>(); 
        // Populate maps
        for (int i = 0; i < queries.length; i++) {
            m1.computeIfAbsent(queries[i][0], k -> new ArrayList<>()).add(i);
            m2.computeIfAbsent(queries[i][1], k -> new ArrayList<>()).add(i);
        }
        int cnt = 0, res = 0;
        // Process each number
        for (int i = 0; i < nums.length; i++) {
            // Add new queries starting at current position
            if (m1.containsKey(i)) {
                for (int x : m1.get(i)) {
                    s1.add(new int[]{queries[x][1], i, x});} }
            // Process queries while we need more elements
            while (cnt < nums[i] && !s1.isEmpty()) {
                s2.add(s1.first());
                res++;
                cnt++;
                s1.remove(s1.first()); }
            // Check if we couldn't satisfy the requirement
            if (cnt < nums[i]) {
                return -1; }
            // Remove ended queries
            if (m2.containsKey(i)) {
                for (int x : m2.get(i)) {
                    int[] query = new int[]{i, queries[x][0], x};
                    if (s2.contains(query)) {
                        cnt--;
                    }
                    s2.remove(query);
                    s1.remove(query);
                } } }
        return queries.length - res;
    }
}