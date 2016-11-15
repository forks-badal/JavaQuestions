package com.webmihir;

import java.util.List;


public interface FinalRevision {
  /**
   * Return all representations of a phone number in character
   * Example:
   * "12" -> ["1a", "1b", "1c", "12"]
   * "23" -> ["ad", "ae", "af", "a3", "bd", "be", "bf", "b3", "cd", "ce", "cf", "c3", "2d", "2e", "2f", "23"]
   */
  public List<String> phoneNumberChars(String s);

  /**
   * Given two strings S1 and S2, find out the minimum edit distance to transform S1 to S2.
   * Edit operations: insertion, deletion, substitution
   *
   * http://www.ideserve.co.in/learn/edit-distance-dynamic-programming
   */
  public int editDistance(String s1, String s2);

  /**
   * Given a string S, find the longest palindromic substring.
   *
   * http://www.ideserve.co.in/learn/longest-palindromic-subsequence
   */
  public String longestPalindromSubSequence(String s);
}
