package Backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, 0, list, result);
        return result;
    }

    private void solve(int[] candidates, int i, int target, int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (i == candidates.length || sum > target)
            return;

        list.add(candidates[i]);
        solve(candidates, i, target, sum + candidates[i], list, result);
        list.remove(list.size() - 1);
        solve(candidates, i + 1, target, sum, list, result);
    }
}
