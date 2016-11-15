package com.webmihir;

import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.Assertion;


public class AssertHelper {
  public static void Assert(boolean b) {
    Assert(b, null);
  }

  public static void Assert(boolean b, String msg) {
    if (!b) {
      if (msg == null) {
        throw new AssertionError();
      } else {
        throw new AssertionError(msg);
      }
    }
  }

  public static void AssertEquals(int actual, int expected) {
    Assert(actual == expected, "Actual: " + actual + ", Expected: " + expected);
  }

  public static <T> void AssertEquals(List<T> expected, List<T> actual) {
    List<T> expList = new ArrayList<T>(expected);
    List<T> actList = new ArrayList<T>(actual);

    expList.removeAll(actual);
    actList.removeAll(expected);

    Assert(actList.size() == 0, "Extra Elements: " + actList);
    Assert(expList.size() == 0, "Extra Elements: " + expList);
  }

  public static void AssertEquals(String actual, String expected) {
    Assert(actual == null && expected == null || actual.equals(expected),
        "Actual: " + actual + ", Expected: " + expected);
  }

  public static void AssertEquals(boolean actual, boolean expected) {
    Assert(actual == expected, "Actual: " + actual + ", Expected: " + expected);
  }
}
