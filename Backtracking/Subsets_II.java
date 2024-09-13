package Backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        solve(nums, 0, result, list, set);
        return result;
    }

    private void solve(int[] nums, int i, List<List<Integer>> result, List<Integer> list, Set<List<Integer>> set) {
        if (i == nums.length) {
            List<Integer> newList = new ArrayList<>(list);
            if (set.add(newList)) {
                result.add(newList);
            }
            return;
        }

        list.add(nums[i]);
        solve(nums, i + 1, result, list, set);
        list.remove(list.size() - 1);
        solve(nums, i + 1, result, list, set);
    }
}
