class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
                i++;
            }
            for (int j = i; j >= start; j -= 2) {
                res += nums[j];
            }
        }
        return res;
    }
}

// class Solution {
//     public long findScore(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][2];

//         for (int i = 0; i < n; i++) {
//             dp[i][0] = nums[i];
//             dp[i][1] = i;
//         }

//         Arrays.sort(dp, (a, b) -> a[0] - b[0]);

//         boolean[] marked = new boolean[n];
//         long result = 0;

//         for (int[] arr : dp) {
//             int val = arr[0];
//             int ind = arr[1];

//             if (!marked[ind]) {
//                 result += val;

//                 marked[ind] = true;
//                 if (ind > 0)
//                     marked[ind - 1] = true;
//                 if (ind < n - 1) 
//                     marked[ind + 1] = true;
//             }
//         }

//         return result;
//     }
// }


// class Solution {
//     public long findScore(int[] nums) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
//         for(int i=0;i<nums.length;i++){
//             pq.offer(new int[]{nums[i],i});
//         }
//         Set<Integer> set = new HashSet<>();
//         long score=0;
//         while(!pq.isEmpty() && set.size()!=nums.length){
//             int[] top = pq.poll();
//             if(set.contains(top[1]))
//             continue;
//             score+=(int)top[0];
//             if(top[1]-1>=0)
//             set.add(top[1]-1);
//             if(top[1]+1<nums.length)
//             set.add(top[1]+1);
//         }
//         return score;
//     }
// }


// class Solution {
//     public long findScore(int[] nums) {
//         PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> 
//         {if(a[0] != b[0]){
//             return a[0]-b[0];
//         }
//         else{
//             return a[1]-b[1];
//         }});

//         for(int i = 0; i < nums.length; i++){
//             que.add(new int[]{nums[i], i});
//         }

//         long score = 0;
//         boolean [] marked = new boolean[nums.length];
        
//         while(!que.isEmpty()){
//             int[] curr = que.poll();
//             if(!marked[curr[1]]){
//                 score += curr[0];
//                 marked[curr[1]] = true; 
//                 if(curr[1] > 0){
//                     marked[curr[1]-1] = true; 
//                 }
//                 if(curr[1] < nums.length-1){
//                     marked[curr[1]+1] = true;
//                 }
                
//             }
//         }
//         return score;

//     }
// }