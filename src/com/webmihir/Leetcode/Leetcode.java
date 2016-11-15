package com.webmihir.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


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

  /**
   * Given a String S, find the longest palindromic substring of S.
   * You may assume that the maximum length for S is 1000,
   * and there exists only one unique longest palindrominc substring
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }

    int maxLength = 0;
    int maxBeginsWith = 0;
    boolean[][] resultArray = new boolean[s.length()][s.length()];

    //Size 1
    for (int i = 0; i < s.length(); i++) {
      resultArray[i][i] = true;
      maxLength = 1;
      maxBeginsWith = i;
    }

    //Size 2
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        resultArray[i][i+1] = true;
        maxLength = 2;
        maxBeginsWith = i;
      }
    }

    for (int i = 3; i <= s.length(); i++) {
      for (int j = 0; j < s.length() - i + 1; j++) {
        if (s.charAt(j) == s.charAt(j + i - 1) &&
            resultArray[j+1][j + i - 2] == true) {
          resultArray[j][j + i - 1] = true;
          maxLength = i;
          maxBeginsWith = j;
        }
      }
    }

    return s.substring(maxBeginsWith, maxBeginsWith + maxLength);
  }

  /**
   * ZigZag Conversion - https://leetcode.com/problems/zigzag-conversion/
   * @param s
   * @param numRows
   * @return
   */
  public String convert(String s, int numRows) {
    if (numRows == 1 || s == null) {
      return s;
    }

    StringBuilder str = new StringBuilder();
    int step = (numRows * 2) - 2;
    int step2 = (step / 2);

    for (int i = 0; i < numRows; i++) {
      //First & last rows
      if (i == 0 || i == numRows - 1) {
        for (int j = i; j < s.length(); j+=step) {
          str.append(s.charAt(j));
        }
      }

      //Middle rows
      else {
        for (int j = i; j < s.length(); j+=step2) {
          str.append(s.charAt(j));
        }
      }
    }

    return str.toString();
  }

  /**
   * https://leetcode.com/problems/palindrome-number/
   * @param x
   * @return
   */
  public boolean isPalindrome(int x) {
    if ( x < 0 ) {
      return false;
    }

    int digits = 0;
    int y = x;
    while (y > 0) {
      digits ++;
      y = y / 10;
    }

    while ( digits > 0 ) {
      int pow = (int)(Math.pow(10, digits - 1));
      int unit = x % 10;
      if (unit == x / pow) {
        x = (x - (unit*pow)) / 10;
        digits -= 2;
      } else {
        return false;
      }
    }

    return true;
  }

  /**
   * https://leetcode.com/problems/implement-strstr/
   * @param haystack
   * @param needle
   * @return
   */
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
      return -1;
    }

    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == 0) {
      return -1;
    }

    int idx = -1;
    int idxN = 0;
    boolean found = false;

    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(idxN)) {
        idx = i;
        int k = i+1;
        idxN++;
        while (idxN < needle.length() && k < haystack.length()) {
          if (needle.charAt(idxN++) != haystack.charAt(k++)) {
            idx = -1;
            break;
          }
        }
        found = (idx != -1 && idxN == needle.length());
      }

      if (found) {
        break;
      } else {
        idxN = 0;
      }
    }

    return found ? idx : -1;
  }

  /**
   * https://leetcode.com/problems/add-binary/
   * @param a
   * @param b
   * @return
   */
  public String addBinary(String a, String b) {
    StringBuilder str = new StringBuilder();

    if (a == null || a.length() == 0) return b;
    if (b == null || b.length() == 0) return a;

    String smaller = a;
    String larger = b;
    if (a.length() > b.length()) {
      smaller = b;
      larger = a;
    }

    int carry = 0;
    for (int i = 1; i <= larger.length(); i++) {
      int l = larger.charAt(larger.length() - i) - '0';
      int s = i > smaller.length() ? 0 : smaller.charAt(smaller.length() - i) - '0';

      if (l + s + carry == 0) {
        str.insert(0, "0");
        carry = 0;
      }
      else if (l + s + carry == 3) {
        str.insert(0, "1");
        carry = 1;
      }
      else if (l + s + carry == 2) {
        str.insert(0, "0");
        carry = 1;
      }
      else if (l + s + carry == 1) {
        str.insert(0, "1");
        carry = 0;
      }
      else {
        return null;
      }
    }

    if (carry == 1) {
      str.insert(0, "1");
    }
    return str.toString();
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    if (magazine == null) return false;
    if (ransomNote == null) return true;

    HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
    int j = 0;

    for (int i = 0; i < ransomNote.length(); i++) {
      char ch = ransomNote.charAt(i);
      if (!chars.containsKey(ch) || chars.get(ch) == 0) {
        boolean found = false;
        while (j < magazine.length()) {
          char ch2 = magazine.charAt(j++);
          if (ch != ch2) {
            chars.put(ch2, chars.getOrDefault(ch2, 0)+1);
          } else {
            found = true;
            break;
          }
        }
        if (!found) return false;
      } else {
        chars.put(ch, chars.get(ch)-1);
      }
    }

    return true;
  }
}

