class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dp(res, subset, 0, 0, target, nums);

        return res;
    }

    public void dp(List<List<Integer>> res, List<Integer> subset, int sum, int start, int target, int[] nums){
        if(sum == target){
            res.add(new ArrayList<>(subset));
            return;
        }

        if(sum > target){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dp(res, subset, sum + nums[i], i, target, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
