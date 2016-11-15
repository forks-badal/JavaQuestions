package com.webmihir.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    if (n < 1) return null;

    Set<String> result = new HashSet<String>();
    Set<String> prev = new HashSet<String>();
    prev.add("()");

    for (int i = 2; i <= n; i++) {
      for (String s : prev) {
        String newStr = s + "()";
        if (!result.contains(newStr)) {
          result.add(newStr);
        }

        newStr = "()" + s;
        if (!result.contains(newStr)) {
          result.add(newStr);
        }

        newStr = "(" + s + ")";
        if (!result.contains(newStr)) {
          result.add(newStr);
        }
      }
      prev.clear();
      prev.addAll(result);
      result.clear();
    }

    return new ArrayList(prev);
  }
}
