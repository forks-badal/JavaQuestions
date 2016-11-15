package com.webmihir.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;


public class TopKElements {
  public List<Integer> topKFrequent(int[] nums, int k) {
    Arrays.sort(nums);
    int max = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i : nums) {
      int cnt = map.getOrDefault(i, 0) + 1;
      if (cnt > max) max = cnt;
      map.put(i,cnt);
    }

    TreeSet<Map.Entry<Integer,Integer>> entrySet = new TreeSet<>(new Comparator<Map.Entry<Integer,Integer>>(){
      public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b) {
        int diff1 = a.getValue() - b.getValue();
        if (diff1 != 0) return diff1;
        return a.getKey() - b.getKey();
      }
    });
    //entrySet.addAll(map.entrySet());
    for(Map.Entry e : map.entrySet()) entrySet.add(e);

    List<Integer> result = new ArrayList<Integer>(k);
    for(int i = 0; i < k; i++) {
      Map.Entry<Integer,Integer> e = entrySet.pollLast();
      result.add(e.getKey());
    }
    return result;
  }

}
