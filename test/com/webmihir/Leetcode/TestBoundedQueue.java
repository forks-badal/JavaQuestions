package com.webmihir.Leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;


public class TestBoundedQueue {
  @Test
  public void test1() throws Exception {
    BoundedQueue<Integer> q = new BoundedQueue<>(1);
    q.offer(1);

    Runnable r1 = () -> {
      System.out.println("R1 about to enqueue...");
      try {
        q.offer(2);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("R1 successfully enqueued!");
    };

    Runnable r2 = () -> {
      System.out.println("R2 sleeping...");
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("R2 removed " + q.poll() + " from Queue");
    };

    ExecutorService e = Executors.newFixedThreadPool(2);
    e.submit(r1);
    e.submit(r2);
    e.shutdown();
    e.awaitTermination(10, TimeUnit.SECONDS);
    System.out.println("Done");
  }
}
