class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] start_index = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            start_index[i] = new int[] { intervals[i][0], i };
        }
        Arrays.sort(start_index, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(start_index[i][0] + " ");
        }
        System.out.println();
        int[] ret = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            ret[i] = greaterThanOrEqualTo(start_index, end);
        }
        return ret;
    }

    public int greaterThanOrEqualTo(int[][] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid][0] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (start < 0 || start > nums.length - 1) {
            return -1;
        }
        System.out.println(target + " " + start);
        return nums[start][1];
    }
}


//O(nlogn)

// class Solution {
//    public int[] findRightInterval(int[][] intervals) {
//         int n = intervals.length;
//         int[] arr = new int[n];
//         int[] ans = new int[n];
//         for(int i = 0; i < n; ++i)
//             arr[i] = intervals[i][0];
//         Map<Integer,Integer> map = new HashMap<>();
//         for(int i = 0; i < n; ++i)
//             map.put(arr[i],i);
//         Arrays.sort(arr);
//         for(int i = 0; i < n; ++i){
//             int val = binarySearch(arr,intervals[i][1]);
//             if(val == -1)
//                 ans[i] = -1;
//             else
//              ans[i] = map.get(arr[val]);
//         }
//         return ans;
//     }
//     int binarySearch(int[] arr,int target){
//         int l = 0;
//         int r = arr.length - 1;
//         int ans = -1;
//         while(l <= r){
//             int mid = l + (r - l)/2;
//             if(arr[mid] == target)
//                 return mid;
//             else if(arr[mid] > target){
//                 ans = mid;
//                 r = mid - 1;
//             }
//             else
//                 l = mid + 1;
//         }
//         return ans;
//     }
//  }