package com.webmihir.Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;


/**
 * Given an Array of Strings, return the top N most frequent words
 *
 * Example,
 * 1) array = {"foo", "bar", "bar", "lite", "foo", "bar"}, N=2 --> return {"bar", "foo"}
 * 2) array = {"foo", "bar", "bar", "lite", "foo", "bar"}, N=1 --> return {"bar"}
 * 3) array = {"foo", "bar", "bar", "lite", "foo", "bar"}, N=3 --> return {"foo", "bar", "lite"}
 *
 */
public class TopFrequentWords {
  private class QEntry {
    public String string;
    public int frequency;

    public QEntry(String string) {
      this.string = string;
      frequency = 0;
    }
  }

  public List<String> topNFrequentWords(String[] array, int N) {
    List<String> ret = new ArrayList<>(N);
    PriorityQueue<QEntry> q = new PriorityQueue<>(N, new Comparator<QEntry>() {
      @Override
      public int compare(QEntry o1, QEntry o2) {
        return o2.frequency - o1.frequency;
      }
    });

    for(String s : array) {
      Optional<QEntry> e = q.stream().filter(p -> p.string.equals(s)).findFirst();
      QEntry entry = null;
      if (e.isPresent()) {
        entry = e.get();
        q.remove(entry);
      }
      else {
        entry = new QEntry(s);
      }

      entry.frequency = entry.frequency + 1;
      q.add(entry);
    }

    int i = 0;
    while (!q.isEmpty() && i < N) {
      ret.add(q.poll().string);
      i++;
    }

    return ret;
  }
}
