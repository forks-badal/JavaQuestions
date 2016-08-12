package com.webmihir;

public class Main {

  public static void main(String[] args) {
    Leetcode lc = new Leetcode();
    double d = lc.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    System.out.println("Expected: 2.5, Actual: " + d);
  }
}
