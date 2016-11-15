package com.webmihir.company.linkedin;

/*
 * The MaxStack is a stacklike data structure that also allows stacklike access to the elements by their value
 * For example, given a stack of {1, 3, 2, 5, 3, 4, 5, 2}
 * peek() -> 2, peekMax() -> 5
 * pop() -> 2; peek() -> 5, peekMax() -> 5
 * pop() -> 5; peek() -> 4, peekMax() -> 5
 * push(6); peek() -> 6, peekMax() -> 6
 * popMax() -> 6; peek -> 4, peekMax() -> 5
 * popMax() -> 5; peek -> 4, peekMax() -> 4
 */
public class MaxStack<T extends Comparable<T>> {
  /**
   * The standard three Stack methods - push adds an element to the stack
   */
  public void push(T toPush) {

  }

  /**
   * Peek returns the top value on the stack
    */
  public T peek() {
    return null;
  }

  /**
   * Pop removes and returns the top value on the stack
   */
  public T pop() {
    return null;
  }

  /**
   * PeekMax() returns the highest value in the stack (remember that T must implement Comparable)
   */
  public T peekMax() {
    return null;
  }

  /**
   * popMax() removes and returns the highest value in the stack
   * */
  public T popMax() {
    return null;
  }
}
