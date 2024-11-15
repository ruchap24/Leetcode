class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetSums(nums, 0, new ArrayList<>(), result);
        return result.stream().distinct().collect(Collectors.toList());
    }
    public void subsetSums(int[] arr, int index, List<Integer> curr, List<List<Integer>> result) {
        if(index == arr.length) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curr);
            result.add(temp);
            return;
        } 
        subsetSums(arr, index + 1, curr, result);
        curr.add(arr[index]);
        subsetSums(arr, index + 1, curr, result);
        curr.remove(curr.size() - 1);
    }
}