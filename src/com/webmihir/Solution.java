package com.webmihir;

import java.util.HashMap;


public class Solution {
  /**
   * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

   * You may assume that each input would have exactly one solution.

   * Example:
   * Given nums = [2, 7, 11, 15], target = 9,

   * Because nums[0] + nums[1] = 2 + 7 = 9,
   * return [0, 1].

   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    if (nums == null) {
      return null;
    }

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }

      map.put(nums[i], i);
    }

    return null;
  }
}
