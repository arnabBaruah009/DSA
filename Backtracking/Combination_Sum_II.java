package Backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, result, list);
        return result;
    }

    private void solve(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            List<Integer> newlist = new ArrayList<>(list);
            result.add(newlist);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue; // Skip duplicates
            if (candidates[i] > target)
                break; // No point in continuing if the current candidate is larger than the target

            list.add(candidates[i]);
            solve(candidates, i + 1, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }
}
