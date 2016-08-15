package com.webmihir;

import java.util.HashMap;
import java.util.HashSet;


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
   * Explanation of solution:
   * for every number in the array, if (target-num) is present in the array, we have found the solution.
   * So loop through the array and check if (target-nums[i]) is present in the hashmap.
   * If not, add nums[i] to the hashmap. Return (i, hashmap[target-nums[i]]) if found, or null if not found.
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
   * Solution Explanation:
   * https://leetcode.com/articles/longest-substring-without-repeating-characters/
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int result = 0;

    if (s == null || s.length() == 0) {
      return result;
    }

    int i = 0, j = 0;

    while (j < s.length()) {
      char ch = s.charAt(j);
      if (!map.containsKey(ch) || map.get(ch) < i) {
        result = Math.max(result, j - i + 1);
        map.put(ch, j++);
      } else {
        i = map.get(ch) + 1;
      }
    }

    return result;
  }

  //Less optimal, N^2 solution of above question
  public int lengthOfLongestSubstring_n_square(String s) {
    int longestLength = 0;

    if (s == null || s.length() == 0) {
      return longestLength;
    }

    for (int i = 0; i < s.length(); i++) {
      HashSet<Character> chars = new HashSet<Character>();
      int currentLength = 1;
      chars.add(s.charAt(i));

      int k = i + 1;
      for (; k < s.length(); k++) {
        if (chars.contains(s.charAt(k))) {
          longestLength = Math.max(longestLength, (k - i));
          break;
        }
        chars.add(s.charAt(k));
      }

      if (k == s.length()) {
        longestLength = Math.max(longestLength, (k - i));
      }
    }
    return longestLength;
  }

  /**
   * There are two sorted arrays nums1 and nums2 of size m and n respectively.
   *
   * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
   *
   * Example 1:
   * nums1 = [1, 3]
   * nums2 = [2]
   * The median is 2.0
   *
   * Example 2:
   * nums1 = [1, 2]
   * nums2 = [3, 4]
   * The median is (2 + 3)/2 = 2.5
   *
   * Solution: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
   *
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int l1 = nums1 != null ? nums1.length : 0;
    int l2 = nums2 != null ? nums2.length : 0;

    int total = l1 + l2;
    if (total % 2 == 1) { //odd number of ints
      int mid = (total + 1) / 2;

      return findElement(nums1, nums2, mid);
    }

    int mid = total / 2;
    return ((double) (findElement(nums1, nums2, mid) + findElement(nums1, nums2, mid + 1))) / 2;
  }

  private int findElement(int[] nums1, int[] nums2, int index) {
    int i = 0, j = 0;

    while (i + j < index - 1) {
      if (i == nums1.length) {
        j++;
      } else if (j == nums2.length) {
        i++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }

    if (i >= nums1.length) {
      return nums2[j];
    }
    if (j >= nums2.length) {
      return nums1[i];
    }
    return Math.min(nums1[i], nums2[j]);
  }
}

