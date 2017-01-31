package com.webmihir.Leetcode;

/**
 * Given a LinkedList with a next and random pointer, deep copy the list.
 * The random pointer could point to itself, another node before or after, or null.
 */
public class DeepCopyListWithRandom {
  public class RandomListNode {
    public int val;
    public RandomListNode next;
    public RandomListNode rand;

    public RandomListNode(int val) {this.val = val;}
  }

  public RandomListNode deepCopy(RandomListNode head) {
    if (head == null) return null;

    RandomListNode curr = head;

    //Pass 1, create new list where each node from original list points to new list's corresponding node
    while (curr != null) {
      RandomListNode next = curr.next;

      RandomListNode newNode = new RandomListNode(curr.val);
      curr.next = newNode;
      newNode.next = next;
      curr = next;
    }

    //Pass 2, fix random node in new list
    curr = head;
    while (curr != null) {
      if (curr.rand != null) {
        curr.next.rand = curr.rand.next;
      }
      curr = curr.next.next;
    }

    //Pass 3, fix original list and next pointers of new list
    RandomListNode newHead = head.next;
    curr = head;
    while (curr != null) {
      RandomListNode newNode = curr.next;
      RandomListNode next = newNode.next;
      curr.next = next;
      newNode.next = (next != null) ? next.next : null;
      curr = next;
    }

    return newHead;
  }
}
