package com.webmihir.PiE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class Recursion {
  //========= FACTORIAL ==============

  /**
   * Return factorial of a number
   * Example:
   * factorial(0) = 1
   * factorial(1) = 1
   * factorial(2) = 2*1 = 2
   * factorial(3) = 3*2*1 = 6
   * factorial(4) = 4*3*2*1 = 24
   */
  public int factorial(int n) {
    if (n <= 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  //========= BINARY SEARCH ==============

  /**
   * Given a sorted array and Integer, return the index where the number exists
   * Do not use recursion
   *
   * Example:
   * binarySearch([1,2,3], 1) = 0
   * binarySearch([1,2,3], 2) = 1
   * binarySearch([1,2,3], 3) = 2
   *
   */
  public int binarySearchIterative(int[] array, int n) {
    if (array == null || array.length == 0) {
      throw new NoSuchElementException();
    }

    int lower = 0;
    int upper = array.length - 1;

    return binarySearchIterative(array, n, lower, upper);
  }

  private int binarySearchIterative(int[] array, int n, int lower, int upper) {
    while (lower <= upper) {
      int mid = (lower + upper) / 2;

      if (array[mid] == n) {
        return mid;
      } else if (array[mid] < n) {
        lower = mid + 1;
      } else {
        upper = mid - 1;
      }
    }

    return -1;
  }

  /**
   * Given a sorted array and Integer, return the index where the number exists
   * Example:
   * binarySearch([1,2,3], 1) = 0
   * binarySearch([1,2,3], 2) = 1
   * binarySearch([1,2,3], 3) = 2
   *
   */
  public int binarySearchRecursive(int[] array, int n) {
    if (array == null || array.length == 0) {
      throw new NoSuchElementException();
    }

    int lower = 0;
    int upper = array.length - 1;

    return binarySearchRecursive(array, n, lower, upper);
  }

  private int binarySearchRecursive(int[] array, int n, int lower, int upper) {
    if (lower > upper) {
      return -1;
    }

    int mid = (lower + upper) / 2;

    if (array[mid] == n) {
      return mid;
    }

    if (array[mid] < n) {
      return binarySearchRecursive(array, n, mid + 1, upper);
    } else {
      return binarySearchRecursive(array, n, lower, mid - 1);
    }
  }

  //========== PERMUTATION ==============

  /**
   * Return all permutations of a String
   * Example:
   * permute("ab") -> {"ab", "ba"}
   * permute("abc") -> {"abc", "acb", "bac", "bca", "cab", "cba"}
   */
  public List<String> permute(String s) {
    if (s == null || s.length() <= 1) {
      return new ArrayList<String>(Collections.singleton(s));
    }

    List<String> results = new LinkedList<>();
    permute(s, "", results);

    return results;
  }

  private void permute(String s, String soFar, List<String> res) {
    if (s.length() == 0) {
      res.add(soFar + s);
    } else {
      for (int i = 0; i < s.length(); i++) {
        permute(s.substring(0, i) + s.substring(i + 1, s.length()), soFar + s.charAt(i), res);
      }
    }
  }

  //========== TELEPHONE NUMBER ==========

  /**
   * Return all representations of a phone number in character
   * Example:
   * "12" -> ["1a", "1b", "1c", "12"]
   * "23" -> ["ad", "ae", "af", "a3", "bd", "be", "bf", "b3", "cd", "ce", "cf", "c3", "2d", "2e", "2f", "23"]
   *
   * @param s
   * @return
   */
  public List<String> phoneNumberChars(String s) {
    List<String> results = new LinkedList<>();

    phoneNumberChars(s, "", results);
    return results;
  }

  private void phoneNumberChars(String s, String soFar, List<String> results) {
    if (s.length() == 0) {
      results.add(soFar);
      return;
    }

    for (int j = 0; j < intToChars(s.charAt(0)).length; j++) {
      phoneNumberChars(s.substring(1), soFar + intToChars(s.charAt(0))[j], results);
    }
  }

  private char[] intToChars(char c) {
    switch (c) {
      case '1':
        return new char[]{'1'};
      case '2':
        return new char[]{'a', 'b', 'c', '2'};
      case '3':
        return new char[]{'d', 'e', 'f', '3'};
      case '4':
        return new char[]{'g', 'h', 'i', '4'};
      case '5':
        return new char[]{'j', 'k', 'l', '5'};
      case '6':
        return new char[]{'m', 'n', 'o', '6'};
      case '7':
        return new char[]{'p', 'q', 'r', 's', '7'};
      case '8':
        return new char[]{'t', 'u', 'v', '8'};
      case '9':
        return new char[]{'w', 'x', 'y', 'z', '9'};
      case '0':
        return new char[]{'0'};
    }

    //Unknown character
    throw new IllegalArgumentException();
  }
}
