package com.webmihir.Leetcode;

import com.webmihir.DataProviderSrc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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

  @Test
  public void testBoundedQueueSingleThread() throws Exception {
    BoundedQueue<Integer> q = new BoundedQueue<>(3);
    Assert(q.offer(1));
    AssertEquals(q.poll(), 1);
    Assert(q.poll() == null);

    Assert(q.offer(1));
    Assert(q.offer(2));
    Assert(q.offer(3));
    Assert(! q.offer(4, 1, TimeUnit.SECONDS));

    AssertEquals(q.poll(), 1);
    Assert(q.offer(4));
    AssertEquals(q.poll(), 2);
    AssertEquals(q.poll(), 3);
    AssertEquals(q.poll(), 4);
    Assert(q.poll() == null);
  }

  @Test
  public void testBoundedQueueMultiThread() throws Exception {
    BoundedQueue<Integer> q = new BoundedQueue<>(3);
    Queue<String> set = new LinkedList<>();

    Callable<Boolean> t1 = () -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (Exception e) {}
      System.out.println("t1 Inserting");
      boolean b = q.offer(1);
      System.out.println("t1 done");
      set.add("t1");
      return b;
    };

    Callable<Boolean> t2 = () -> {
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (Exception e) {}
      System.out.println("t2 Inserting");
      boolean b = q.offer(2);
      System.out.println("t2 done");
      set.add("t2");
      return b;
    };

    Callable<Boolean> t3 = () -> {
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (Exception e) {}
      System.out.println("t3 Inserting");
      boolean b = q.offer(3);
      System.out.println("t3 done");
      set.add("t3");
      return b;
    };

    Callable<Boolean> t4 = () -> {
      try {
        TimeUnit.SECONDS.sleep(4);
      } catch(Exception e) {}
      System.out.println("t4 Inserting");
      boolean b = q.offer(4);
      System.out.println("t4 done");
      set.add("t4");
      return b;
    };

    Callable<Integer> t5 = () -> {
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch(Exception e) {}
      System.out.println("t5 polling...");
      Integer i = q.poll();
      System.out.println("t5 done");
      set.add("t5");
      return i;
    };

    ExecutorService service = Executors.newFixedThreadPool(20);
    Future<Boolean> f1 = service.submit(t1);
    Future<Boolean> f2 = service.submit(t2);
    Future<Boolean> f3 = service.submit(t3);
    Future<Boolean> f4 = service.submit(t4);
    Future<Integer> f5 = service.submit(t5);

    Assert(f1.get());
    Assert(f2.get());
    Assert(f3.get());
    Assert(f4.get());
    AssertEquals(f5.get(), 1);

    //We expect t5 to complete before t4 since t4 offer has to wait till poll completes
    String[] expectedOrder = new String[] {"t1", "t2", "t3", "t5", "t4"};
    Iterator<String> iter = set.iterator();
    int k = 0;
    while(iter.hasNext()) {
      AssertEquals(iter.next(), expectedOrder[k]);
      k++;
    }

    service.shutdown();
  }
}
