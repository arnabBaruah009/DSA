package Backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, result);
        return result;
    }

    private void solve(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x = 0; x < nums.length; x++) {
                list.add(nums[x]);
            }
            result.add(list);
            return;
        }

        for (int x = i; x < nums.length; x++) {
            swap(nums, i, x);
            solve(nums, i + 1, result);
            swap(nums, i, x);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
