package com.webmihir;

import com.webmihir.Leetcode.BasicCalculator;
import com.webmihir.Leetcode.GenerateParenthesis;
import com.webmihir.Leetcode.RandomIndexPicker;
import com.webmihir.Leetcode.SpiralOrder;
import com.webmihir.Leetcode.TopKElements;
import com.webmihir.Leetcode.WordLadder;
import com.webmihir.company.linkedin.Factors;
import com.webmihir.company.linkedin.FallingLeaves;
import com.webmihir.company.linkedin.MiddleStack;
import com.webmihir.company.linkedin.RGBColorAssignment;
import com.webmihir.company.linkedin.RomanNumberals;
import com.webmihir.company.linkedin.StringPermute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Main {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x, TreeNode l, TreeNode r) { val = x; left = l; right = r; }
    TreeNode (int x) {val = x;}
  };

  public static void main(String[] args) {
//    verifyRotate();
//    verifyRomanNumerals();
//    verifyPermute();
//    verifyFactors();
//    verifyRGBColorAssignments();
//    verifyFallingLeaves();
//    verifyMiddleStack();
//    verifyTopKElements();
//    verifyGenerateParenthesis();
//    verifyBasicCalculator();
//    verifyWordLadder();
//    verifyRandomIndexPicker();
//    verifySpiralOrder();
    verifyPrintFactors();
  }

  static void verifySpiralOrder() {
    int[][]matrix = new int[1][10];
    for (int i = 0; i < 10; i++) matrix[0][i] = i+1;
    SpiralOrder s = new SpiralOrder();
    List<Integer> lst = s.spiralOrder(matrix);
    printList(lst);

    matrix = new int[10][1];
    for (int i = 0; i < 10; i++) matrix[i][0] = i+1;
    lst = s.spiralOrder(matrix);
    printList(lst);
  }

  static void printList(List<Integer> list) {
    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()) {
      System.out.print (iter.next());
      System.out.print(" ");
    }
    System.out.println();
  }
  static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {System.out.print(curr.val + "->"); curr = curr.next; }
    System.out.println();
  }

  static class ListNode {
    ListNode next;
    int val;
    ListNode(int x) { val = x;}
  }
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) return head;
    ListNode newHead = head;
    int size = 0;

    //get size & new head
    ListNode curr = head;
    while (curr != null) {
      size ++;
      if (size == k) newHead = curr;
      curr = curr.next;
    }

    ListNode a = head;
    ListNode b = head.next;
    ListNode c = b == null ? null : b.next;

    ListNode prevHead = null;
    while (size >= k) {
      int round = 0;
      ListNode bak = a;
      while (round != k - 1) {
        round ++;
        b.next = a;
        a = b;
        b = c;
        c = (b == null) ? null : b.next;
      }
      if (prevHead != null) {
        prevHead.next = a;
      }
      prevHead = bak;
      prevHead.next = b;
      a = b;
      b = c;
      c = (b == null) ? null : b.next;
      size -= k;
    }

    return newHead;
  }

  static void verifyRandomIndexPicker() {
    RandomIndexPicker rip = new RandomIndexPicker(new int[] {1,2,3,3,3});
    for (int i = 0; i < 100; i++) {
      System.out.println(rip.pick(3));
    }
  }

  static void verifyWordLadder() {
    WordLadder ladder = new WordLadder();
    Set<String> set = new HashSet<>();
//    "talk", "tail", ["talk","tons","fall","tail","gale","hall","negs"]
//    "game", "thee", ["frye","heat","tree","thee","game","free","hell","fame","faye"]
//    "kiss", "tusk", ["miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"]
    set.add("miss"); set.add("dusk"); set.add("kiss");  set.add("musk");  set.add("tusk");  set.add("diss");
    set.add("disk"); set.add("sang"); set.add("ties"); set.add("muss");

    int k = ladder.ladderLength("kiss", "tusk", set);
  }

  static void verifyBasicCalculator() {
    BasicCalculator calc = new BasicCalculator();
    int i = calc.calculate("1-1");
    assert (i==0);
  }

  static void verifyGenerateParenthesis() {
    List<String> strs = new GenerateParenthesis().generateParenthesis(3);
    assert (strs.size() == 5);
  }

  static void verifyTopKElements() {
    TopKElements elems = new TopKElements();
    List<Integer> res = elems.topKFrequent(new int[] {1,2}, 2);
    assert(res.contains(1));
    assert(res.contains(2));
    assert(res.size() == 2);
  }

  static void verifyMiddleStack() {
    MiddleStack<Integer> stack = new MiddleStack<>(); //stack = [ ]
    assert (stack.peekMiddle() == null);
    stack.push(5); //stack = [5]
    assert (stack.peekMiddle() == 5);
    stack.push(4); //stack = [4,5]
    assert (stack.peekMiddle() == 4);
    stack.push(3); //stack = [3, 4, 5]
    assert (stack.peekMiddle() == 3);
    stack.pop(); //stack = [4, 5]
    assert (stack.peekMiddle() == 4);
    stack.pop(); //stack = [5]
    assert (stack.peekMiddle() == 5);
    stack.pop(); // stack = [ ]
    assert (stack.peekMiddle() == null);

    MiddleStack<Integer> stack2 = new MiddleStack<>();
    stack2.push(5); //stack = [5], mid=5
    assert (stack2.popMiddle() == 5);
    assert(stack2.peekMiddle() == null);
    stack2.push(5); stack2.push(4); //stack = [4, 5], mid=4
    assert(stack2.popMiddle() == 4);
    assert(stack2.peekMiddle() == 5);
    stack2.push(3); stack2.push(2); //stack = [2, 3, 5], mid=3
    assert(stack2.popMiddle() == 3);
    assert(stack2.peekMiddle() == 5);
    stack2.push(1); stack2.push(0); //stack = [0, 1, 2, 5], mid=1
    assert(stack2.popMiddle() == 1);
    assert(stack2.peekMiddle() == 2);
    stack2.push(-1); stack2.push(-2); //stack = [-2, -1, 0, 2, 5], mid=0
    assert(stack2.popMiddle() == 0);
    assert(stack2.peekMiddle() == -1);
  }

  static void verifyFallingLeaves() {
    FallingLeaves fl = new FallingLeaves();
    FallingLeaves.Node root = new FallingLeaves.Node();

    //level 0
    root.left = new FallingLeaves.Node();
    root.right = new FallingLeaves.Node();
    root.value = 5;

    //level 1
    root.left.value = 3;
    root.left.left = new FallingLeaves.Node();
    root.left.right = new FallingLeaves.Node();
    root.right.value = 10;
    root.right.left = new FallingLeaves.Node();
    root.right.right = new FallingLeaves.Node();

    //level 2
    root.left.left.value = 2;
    root.left.right.value = 1;
    root.right.left.value = 7;
    root.right.right.value = 8;

    //level 3
    root.left.left.left = new FallingLeaves.Node();
    root.left.left.left.value = 0;
    fl.fallingLeaves(root);
  }

  static void verifyRGBColorAssignments() {
    RGBColorAssignment color = new RGBColorAssignment();
    System.out.println(color.paintHouses(new int[][] { {2, 2, 6, 4, 2}, {0, 5, 7, 1, 1}, {1, 1, 2, 0, 4}}));
  }

  static void verifyPrintFactors() {
    Factors factors = new Factors();
    factors.printFactors(16);
    factors.printFactors(8);
    factors.printFactors(7);
  }
  static void verifyFactors() {
    Factors factors = new Factors();
    List<String> result = factors.factors(8);
    for (String s : result) System.out.println(s);

    System.out.println();
    result = factors.factors(96);
    for (String s : result) System.out.println(s);
  }
  static void verifyRomanNumerals() {
    RomanNumberals r = new RomanNumberals();
    System.out.println("10 = " + r.toRomanNumerals(10));
    System.out.println("99 = " + r.toRomanNumerals(99));
    System.out.println("8 = " + r.toRomanNumerals(8));
    System.out.println("4 = " + r.toRomanNumerals(4));

    System.out.println("X = " + r.fromRomanNumberal("X"));
    System.out.println("XCIX = " + r.fromRomanNumberal("XCIX"));
    System.out.println("VIII = " + r.fromRomanNumberal("VIII"));
    System.out.println("IV = " + r.fromRomanNumberal("IV"));

    System.out.println("MCMXXXIV (1934) = " + r.fromRomanNumberal("MCMXXXIV"));
    System.out.println("MCDXCII (1492) = " + r.fromRomanNumberal("MCDXCII"));
    System.out.println("MCCCXXXVII (1337) = " + r.fromRomanNumberal("MCCCXXXVII"));
  }

  static void verifyPermute() {
    StringPermute per = new StringPermute();
    per.permute("abcd");
  }

  static void verifyRotate() {
    int[] n = new int[] {1,2};
    rotate(n, 1);
    System.out.println(n);
  }

  public static void rotate(int[] nums, int k) {
    if (nums == null) return;

    if (k == 0) return;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] nums, int start, int end) {
    int i = start;
    int j = end;

    while (i < j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
}
