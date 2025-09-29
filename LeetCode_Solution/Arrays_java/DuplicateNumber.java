/*
Problem: Find All Duplicates in an Array
LeetCode Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
Difficulty: Medium

Approach:
- Use cyclic sort to rearrange numbers such that each number nums[i] should be placed at index nums[i] - 1.
- After rearranging, if nums[i] != i+1, it means nums[i] is a duplicate.
- Collect all such duplicates in a list and return it.

Time Complexity: O(n), since each number is swapped at most once.
Space Complexity: O(1), ignoring the output list (since we only use a few variables).
*/

import java.util.*;

class DuplicateNumber {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Rearrange numbers using cyclic sort
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Collect duplicates
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
