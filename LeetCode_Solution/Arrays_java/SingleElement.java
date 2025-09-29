/*
Problem: Single Element in a Sorted Array
LeetCode Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
Difficulty: Medium

Approach:
- Since the array is sorted and every element appears exactly twice except one:
  - Traverse through the array.
  - If nums[i] == nums[i+1], skip both by incrementing i.
  - Otherwise, return nums[i] as it is the unique element.
- If no element found in the loop, the last element must be the unique one.

Time Complexity: O(n), where n is the length of nums
Space Complexity: O(1), no extra space used
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++; 
                continue;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
