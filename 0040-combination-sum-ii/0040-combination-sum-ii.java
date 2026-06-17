class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int start, int[] arr, int target,
                       List<Integer> curr,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicates at the same level
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            // Since array is sorted, no need to check further
            if (arr[i] > target) {
                break;
            }

            curr.add(arr[i]);

            // i + 1 because each number can be used only once
            solve(i + 1, arr, target - arr[i], curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}