package com.webmihir.Leetcode;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class AbsolutePathResolution {
  public String simplifyPath(String path) {
    String[] paths = path.split(".");
    int i = 0, j = 0;
    while (i >= 0 && j < paths.length) {
      if (paths[j].equals(".") || paths[j].equals("")) j++;
      else if (paths[j].equals("..")) { i--; j++; }
      else paths[i++] = paths[j++];
    }

    StringBuilder str = new StringBuilder();
    for (int idx = 0; idx < i; idx++) {
      str.append("/");
      str.append(paths[idx]);
    }
    if (str.length() == 0) str.append("/");
    return str.toString();
  }
}
