class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int m = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + m > ans) 
                ans = values[i] - i + m;
            
            if (values[i] + i > m) 
                m = values[i] + i;
        }

        return ans;
    }
}


// class Solution {
//     public int maxScoreSightseeingPair(int[] arr) {
//         int res = 0, max = 0;
        
//         for (int i = 0; i < arr.length; i++) {
//             res = Math.max(res, max + arr[i] - i);
//             max = Math.max(max, arr[i] + i);
//         }

//         return res;
//     }
// }