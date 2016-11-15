package com.webmihir;

import com.webmihir.Leetcode.Leetcode;
import com.webmihir.PiE.Recursion;
import com.webmihir.Topcoder.DynamicProgramming;
import org.testng.annotations.DataProvider;


public class DataProviderSrc {

  //Programming Interviews Exposed
  private static Recursion[] _pieRecursion = { new Recursion() };

  //TopCoder
  private static DynamicProgramming[] _topCoderDP = { new DynamicProgramming() };

  //LeetCode
  private static Leetcode[] _leetCode = { new Leetcode() };

  @DataProvider(name = "PiERecursion")
  public static Object[][] getPiERecursion() {
    return new Object[][]{_pieRecursion};
  }

  @DataProvider(name = "TopCoderDP")
  public static Object[][] getTopCoderDP() {
    return new Object[][] {_topCoderDP};
  }

  @DataProvider(name = "Leetcode")
  public static Object[][] getLeetCode() {
    return new Object[][] {_leetCode};
  }
}
