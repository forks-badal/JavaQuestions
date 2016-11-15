package com.webmihir.PiE;

import com.webmihir.DataProviderSrc;
import java.util.Arrays;
import org.testng.annotations.Test;

import static com.webmihir.AssertHelper.Assert;
import static com.webmihir.AssertHelper.AssertEquals;


public class TestRecursion {
  @Test(dataProvider = "PiERecursion", dataProviderClass = DataProviderSrc.class)
  public void testFactorial(Recursion r) {
    Assert(r.factorial(1) == 1);
    Assert(r.factorial(0) == 1);
    Assert(r.factorial(-1) == 1);
    Assert(r.factorial(2) == 2);
    Assert(r.factorial(3) == 3 * 2 * 1);
    Assert(r.factorial(5) == 5 * 4 * 3 * 2 * 1);
  }

  @Test(dataProvider = "PiERecursion", dataProviderClass = DataProviderSrc.class)
  public void testBinarySearchIterative(Recursion r) {
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 4), 3);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 1), 0);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 5), 4);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 2), 1);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 3), 2);
    AssertEquals(r.binarySearchIterative(new int[]{1}, 1), 0);
    AssertEquals(r.binarySearchIterative(new int[]{1}, 2), -1);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 6), -1);
    AssertEquals(r.binarySearchIterative(new int[]{1, 2, 3, 4, 5}, 0), -1);
  }

  @Test(dataProvider = "PiERecursion", dataProviderClass = DataProviderSrc.class)
  public void testBinarySearchRecursive(Recursion r) {
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 4), 3);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 1), 0);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 5), 4);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 2), 1);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 3), 2);
    AssertEquals(r.binarySearchRecursive(new int[]{1}, 1), 0);
    AssertEquals(r.binarySearchRecursive(new int[]{1}, 2), -1);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 6), -1);
    AssertEquals(r.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 0), -1);
  }

  @Test(dataProvider = "PiERecursion", dataProviderClass = DataProviderSrc.class)
  public void testPermute(Recursion r) {
    AssertEquals(r.permute("ABC"), Arrays.asList(new String[]{"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"}));
    AssertEquals(r.permute("ABCD"), Arrays.asList(
        new String[]{"ABCD", "ABDC", "ACBD", "ACDB", "ADBC", "ADCB", "BACD", "BADC", "BCAD", "BCDA", "BDAC", "BDCA", "CABD", "CADB", "CBAD", "CBDA", "CDAB", "CDBA", "DABC", "DACB", "DBAC", "DBCA", "DCAB", "DCBA"}));
  }

  @Test(dataProvider = "PiERecursion", dataProviderClass = DataProviderSrc.class)
  public void testPhoneNumberChars(Recursion r) {
    AssertEquals(r.phoneNumberChars("12"), Arrays.asList(new String[]{"1a", "1b", "1c", "12"}));
    AssertEquals(r.phoneNumberChars("23"), Arrays.asList(
        new String[]{"ad", "ae", "af", "a3", "bd", "be", "bf", "b3", "cd", "ce", "cf", "c3", "2d", "2e", "2f", "23"}));
    AssertEquals(r.phoneNumberChars("890"), Arrays.asList(
        new String[]{"tw0", "tx0", "ty0", "tz0", "t90", "uw0", "ux0", "uy0", "uz0", "u90", "vw0", "vx0", "vy0", "vz0", "v90", "8w0", "8x0", "8y0", "8z0", "890"}));
  }
}
