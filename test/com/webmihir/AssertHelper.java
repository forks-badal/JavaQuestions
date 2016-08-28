package com.webmihir;

import java.util.ArrayList;
import java.util.List;


public class AssertHelper {
  public static void Assert(boolean b) {
    if (!b) {
      throw new AssertionError();
    }
  }

  public static <T> void AssertListEquals(List<T> expected, List<T> actual) {
    List<T> expList = new ArrayList<T>(expected);
    List<T> actList = new ArrayList<T>(actual);

    expList.removeAll(actual);
    actList.removeAll(expected);

    Assert(actList.size() == 0);
    Assert(expList.size() == 0);
  }
}
