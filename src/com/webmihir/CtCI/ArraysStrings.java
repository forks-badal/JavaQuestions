package com.webmihir.CtCI;

import java.util.HashMap;
import java.util.HashSet;


/**
 * This class contains questions from the book "Cracking the Coding Interview" 6th Edition, by Gayle Laakmann.
 *
 * Specifically, this contains questions from Chapter 1 - Arrays and Strings
 *
 */
public class ArraysStrings {
  /**
   * 1.1 - Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
   cannot use additional data structures?
   */
  public boolean isUnique(String str) {
    if (str == null) {
      return true;
    }
    HashSet<Character> set = new HashSet<Character>(str.length());
    for (Character c : str.toCharArray()) {
      if (set.contains(c)) {
        return false;
      }
      set.add(c);
    }
    return true;
  }

  /**
   * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
   other.
   */
  public boolean isPermutation(String s1, String s2) {
    if (s1 == null && s2 == null) {
      return true;
    }
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);

      if (!map.containsKey(c)) {
        return false;
      }

      map.put(c, map.get(c) - 1);
      if (map.get(c) == 0) {
        map.remove(c);
      }
    }

    return map.size() == 0;
  }
}
