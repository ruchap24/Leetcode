class Solution {
    public boolean solve(int prefix[], int n, int k) {

        for (int i = 0; i+2*k-1 < n; i++) {
            if (prefix[i+k-1]-prefix[i] == k-1 && prefix[i+2*k-1]-prefix[i+k] == k-1) return true;
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int prefix[] = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + ((nums.get(i)>nums.get(i-1)) ? 1 : 0);
        }
        int low = 1, high = n/2, ans = 1;

        while (low <= high ) {
            int mid = low+(high-low)/2;
            if (solve(prefix, n, mid)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}