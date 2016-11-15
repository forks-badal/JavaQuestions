package com.webmihir.Topcoder;

import com.webmihir.DataProviderSrc;
import org.testng.annotations.Test;

import static com.webmihir.AssertHelper.Assert;
import static com.webmihir.AssertHelper.AssertEquals;


public class TestDynamicProgramming {

  @Test(dataProvider = "TopCoderDP", dataProviderClass = DataProviderSrc.class)
  public void testLongestZigZag(DynamicProgramming dp) {
    AssertEquals(dp.longestZigZag(new int[]{1, 7, 4, 9, 2, 5}), 6);
    AssertEquals(dp.longestZigZag(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}), 7);
    AssertEquals(dp.longestZigZag(new int[]{44}), 1);
    AssertEquals(dp.longestZigZag(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), 2);
    AssertEquals(dp.longestZigZag(new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}), 8);
    AssertEquals(dp.longestZigZag(
        new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244})
        , 36);
    AssertEquals(dp.longestZigZag(new int[]{}), 0);
  }

  @Test(dataProvider = "TopCoderDP", dataProviderClass =  DataProviderSrc.class)
  public void testMaxProfitFromWine(DynamicProgramming dp) {
    int res = 0;
    AssertEquals((res = dp.maxProfitFromWine(new int[] {2, 3, 5, 1, 4})), 50);
    AssertEquals(dp.maxProfitFromWine(new int[] {1, 4, 2, 3}), 29);
  }
}
