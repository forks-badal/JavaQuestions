package com.webmihir.company.linkedin;

/**
 * Design a stack data structure that supports constant-time operations for:
 * - push (push a new value to the stack)
 * - pop (pop out the newest entry from the stack)
 * - peekMiddle (Return the middle element of the stack without modifying the stack)
 * - popMiddle (Return and remove the middle element from the stack)
 */
public class MiddleStack<T> {
  private class Node {
    T value;
    Node next;
    Node prev;
  }

  Node _head; //head of linkedlist
  Node _middle; //middle of linkedlist
  int _size = 0; //size of linkedlist

  public boolean push(T val) {
    Node newNode = new Node();
    newNode.value = val;

    if (_size == 0) {
      _head = newNode;
    } else {
      newNode.next = _head;
      _head.prev = newNode;
      _head = newNode;
    }
    _size ++;

    if (_size == 1) {
      _middle = newNode;
    } else if (_size % 2 == 0) {
      _middle = _middle.prev;
    }
    return true;
  }

  public T pop() {
    if (_size == 0) return null;

    Node oldHead = _head;
    _head = _head.next;
    _size --;

    if (_size == 0) {
      _middle = null;
    } else {
      _head.prev = null;
      if (_size % 2 == 1) {
        _middle = _middle.next;
      }
    }
    return oldHead.value;
  }

  public T peekMiddle() {
    if (_size == 0) return null;
    return _middle.value;
  }

  public T popMiddle() {
    if (_size == 0) return null;

    if (_size <= 2) return pop();
    else {
      Node oldMiddle = _middle;
      oldMiddle.prev.next = oldMiddle.next;
      oldMiddle.next.prev = oldMiddle.prev;
      _size --;

      if (_size % 2 == 0) _middle = _middle.prev;
      else _middle = _middle.next;

      return oldMiddle.value;
    }
  }
}
