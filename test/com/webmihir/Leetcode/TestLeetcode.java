package com.webmihir.Leetcode;

import com.webmihir.DataProviderSrc;
import org.testng.annotations.Test;

import static com.webmihir.AssertHelper.Assert;
import static com.webmihir.AssertHelper.AssertEquals;


public class TestLeetcode {
  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testLongestPalindrome(Leetcode l) {
    AssertEquals(l.longestPalindrome("bb"), "bb");
    AssertEquals(l.longestPalindrome("bbb"), "bbb");
    AssertEquals(l.longestPalindrome("aba"), "aba");
    AssertEquals(l.longestPalindrome("a"), "a");
    AssertEquals(l.longestPalindrome("banana"), "anana");
  }

  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testConvertZigZag(Leetcode l) {
    AssertEquals(l.convert("A", 2), "A");
  }

  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testIsPalindrome(Leetcode l) {
    AssertEquals(l.isPalindrome(0), true);
    AssertEquals(l.isPalindrome(11), true);
    AssertEquals(l.isPalindrome(888), true);
    AssertEquals(l.isPalindrome(121), true);
    AssertEquals(l.isPalindrome(1221), true);
    AssertEquals(l.isPalindrome(9999), true);

    AssertEquals(l.isPalindrome(-1), false);
    AssertEquals(l.isPalindrome(Integer.MAX_VALUE), false);
    AssertEquals(l.isPalindrome(Integer.MIN_VALUE), false);
    AssertEquals(l.isPalindrome(1231), false);
    AssertEquals(l.isPalindrome(1111011110), false);

  }

  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testStrStr(Leetcode l) {
    AssertEquals(l.strStr("mississippi", "issip"), 4);
    AssertEquals(l.strStr("aaa", "aaa"), 0);
    AssertEquals(l.strStr("aaab", "aab"), 1);
  }

  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testAddBinary(Leetcode l) {
    AssertEquals(l.addBinary("1", "1"), "10");
    AssertEquals(l.addBinary("1", "0"), "1");
    AssertEquals(l.addBinary("0", "1"), "1");
    AssertEquals(l.addBinary("11", "11"), "110");
  }

  @Test(dataProvider = "Leetcode", dataProviderClass = DataProviderSrc.class)
  public void testCanConstruct(Leetcode l) {
    Assert(l.canConstruct("abcd", "cbad"));
    Assert(l.canConstruct("bcjefgecda", "hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh"));
  }
}
