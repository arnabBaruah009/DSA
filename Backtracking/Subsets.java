package Backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        solve(nums, 0, list, result);
        return result;
    }

    private void solve(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(nums, i + 1, list, result);
        list.remove(list.size() - 1);
        solve(nums, i + 1, list, result);
    }
}
