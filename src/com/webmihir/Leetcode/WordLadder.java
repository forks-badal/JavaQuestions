package com.webmihir.Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    int length = 0;
    int minLength = Integer.MAX_VALUE;
    boolean found = false;

    String dummy = new String();
    Queue<String> queue = new LinkedList<String>();
    queue.add(beginWord);
    queue.add(dummy);

    while (!queue.isEmpty()) {
      String curr = queue.remove();
      if(curr == dummy) {
        length ++;
        continue;
      }
      if(wordList.contains(curr)) wordList.remove(curr);

      if (isDistanceOne(curr, endWord)) {
        found = true;
        minLength = Math.min(minLength, length + 1);
      } else {
        for (String s : wordList) {
          if (!s.equals(curr) && isDistanceOne(s, curr)) queue.add(s);
        }
        queue.add(dummy);
      }
    }

    return found ? minLength : 0;
  }

  boolean isDistanceOne(String a, String b) {
    int diff = 0;
    if (a.length() != b.length()) return false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        diff ++;
        if (diff > 1) return false;
      }
    }
    return (diff == 1);
  }
}
