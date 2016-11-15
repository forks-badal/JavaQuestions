package com.webmihir.Leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Implement a bounded blocking queue using Arrays as internal structure
 * The constructor must take an Integer argument for MAX size
 * When Queue is full, poll() should wait until there is available free space.
 * When Queue is empty, return NULL or Exception
 *
 * Code must be thread safe, and must implement the following functions:
 * Poll - removes and return the oldest element from the Queue
 * Offer - Add the element to the Queue, or wait until free space is available then add
 */
public class BoundedQueue <T> {
  private final Object[] ARRAY;
  private final int MAX_SIZE;
  private int _count = 0;
  private int _start = 0;
  private int _end = 0;
  Lock lock = new ReentrantLock();
  private final Condition NOT_FULL;

  public BoundedQueue(int size) {
    MAX_SIZE = size;
    ARRAY = new Object[MAX_SIZE];
    NOT_FULL = lock.newCondition();
  }

  public boolean offer(T val) throws Exception {
    return offer(val, 20, TimeUnit.SECONDS);
  }

  public boolean offer (T val, int time, TimeUnit unit) throws Exception {
    lock.lock();
    try {
      while (_count == MAX_SIZE) {
        if (!NOT_FULL.await(time, unit)) return false;
      }
      ARRAY[_end] = val;
      _end = (_end + 1) % MAX_SIZE;
      _count++;

      return true;
    } finally {
      lock.unlock();
    }
  }

  public T poll() {
    lock.lock();
    try {
      if (_count != 0) {
        T val = (T) ARRAY[_start];
        _start = (_start + 1) % MAX_SIZE;
        _count--;
        NOT_FULL.signal();
        return val;
      }
    }
    finally {
      lock.unlock();
    }
    return null;

  }
}
