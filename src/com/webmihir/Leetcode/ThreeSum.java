package com.webmihir.Leetcode;

import java.util.Arrays;


public class ThreeSum {
  public boolean threeNumberSum(int[] array, int sum) {
    if (array == null || array.length < 3) return false;

    Arrays.sort(array);

    for (int i = 0; i < array.length - 2; i++) {
      int j = i+1;
      int k = array.length - 1;
      while (j < k) {
        if (array[i] + array[j] + array[k] == sum) {
          System.out.println("Indexes that sum to " + sum + ": " + i + ", " + j + ", " + k);
          return true;
        }
        else if (array[i] + array[j] + array[k] < sum) {
          j ++;
        } else k--;
      }
    }

    return false;
  }
}
