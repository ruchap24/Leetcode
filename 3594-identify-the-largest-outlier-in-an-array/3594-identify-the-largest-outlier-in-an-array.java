class Solution {
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int largestOutlier = Integer.MIN_VALUE;

        for (int num : nums) {
            int potentialOutlier = totalSum - 2 * num;

            if (frequency.containsKey(potentialOutlier)) {
                if (potentialOutlier == num) {
                    if (frequency.get(num) > 1) {
                        largestOutlier = Math.max(largestOutlier, potentialOutlier);
                    }
                } else {
                    largestOutlier = Math.max(largestOutlier, potentialOutlier);
                }
            }
        }
        return largestOutlier;
    }
}