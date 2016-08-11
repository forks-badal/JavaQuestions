package com.webmihir;

import java.util.HashMap;


public class Leetcode {
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
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
  /**
   * https://leetcode.com/problems/add-two-numbers/
   *
   * You are given two linked lists representing two non-negative numbers.
   * The digits are stored in reverse order and each of their nodes contain a single digit.
   * Add the two numbers and return it as a linked list.
   *
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   * Output: 7 -> 0 -> 8
   * Since 342 + 465 = 807
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode tail = null;
    int carry = 0;

    while (l1 != null || l2 != null) {
      int i1 = (l1 != null) ? l1.val : 0;
      int i2 = (l2 != null) ? l2.val : 0;

      int total = i1 + i2 + carry;
      int nodeVal = total % 10;
      carry = total / 10;

      ListNode newNode = new ListNode(nodeVal);
      if (tail == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }

      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next;
    }

    if (carry > 0) {
      tail.next = new ListNode(carry);
    }

    return head;
  }

  /**
   * For addTwoNumbers question, follow-up variation:
   * What if the the digits in the linked list are stored in non-reversed order? For example:
   *
   * (3 -> 4 -> 2) + (4 -> 6 -> 5) = (8 -> 0 -> 7)
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbersFollowup(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode tail = head;

    while (l1 != null || l2 != null) {
      int i1 = (l1 != null) ? l1.val : 0;
      int i2 = (l2 != null) ? l2.val : 0;

      int total = i1 + i2;
      int nodeVal = total % 10;
      int carry = total / 10;

      tail.val = tail.val + carry;
      ListNode newNode = new ListNode(nodeVal);
      tail.next = newNode;
      tail = tail.next;

      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next;
    }

    if (head.val == 0) {
      return head.next;
    }

    return head;
  }

  /**
   * https://leetcode.com/problems/longest-substring-without-repeating-characters/
   *
   * Given a string, find the length of the longest substring without repeating characters.
   * Examples:
   *
   * Given "abcabcbb", the answer is "abc", which the length is 3.
   *
   * Given "bbbbb", the answer is "b", with the length of 1.
   *
   * Given "pwwkew", the answer is "wke", with the length of 3.
   * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    return 0;
  }
}
