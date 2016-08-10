package com.webmihir;

import java.util.HashMap;


public class Solution {
  /**
   * URL: https://leetcode.com/problems/two-sum/
   *
   * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   *
   * You may assume that each input would have exactly one solution.
   *
   * Example:
   * Given nums = [2, 7, 11, 15], target = 9,
   *
   * Because nums[0] + nums[1] = 2 + 7 = 9,
   * return [0, 1].
   *
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

  /**
   * Supporting class for addTwoNumbers question
   */
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
  /**
   * https://leetcode.com/problems/add-two-numbers/
   *
   * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
   *
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   * Output: 7 -> 0 -> 8
   * Since 342 + 465 = 807
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);

    //TODO: Add code here
    
    return head;
  }
}
