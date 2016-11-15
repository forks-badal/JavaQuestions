package com.webmihir.Leetcode;

import java.util.Arrays;
import java.util.Random;


/**
 * https://leetcode.com/problems/random-pick-index/
 *
 */
public class RandomIndexPicker {
  private int[] _nums;
  public RandomIndexPicker(int[] nums) {
    Arrays.sort(nums);
    _nums = nums;
  }

  public int pick(int target) {
    int k = binSearch(target);
    int l = search(target, k, -1);
    int m = search(target, k, 1);
    if (l == m) return l;

    Random r = new Random();
    return l + r.nextInt(m - l + 1);
  }

  private int binSearch(int target) {
    int low = 0;
    int high = _nums.length - 1;

    while(true) {
      int mid = (low + high) / 2;
      if (_nums[mid] == target) return mid;
      if (_nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
  }

  private int search(int target, int start, int inc) {
    int l = start + inc;
    while (l >= 0 && l < _nums.length) {
      if (_nums[l] != target) break;
      l += inc;
    }
    return l - inc;
  }
}
