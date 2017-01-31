package com.webmihir.company.amazon;

import java.util.Stack;


/**
 * Mirror a Binary tree with and without recursion
 */
public class MirrorBinaryTree {
  public class Node <T> {
    public Node left;
    public Node right;
    public T val;

    public Node(T val) {
      this(val, null, null);
    }

    public Node(T val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public void MirrorBinaryTreeIterative(Node root) {
    if (root == null) return;

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      Node left = node.left;
      Node right = node.right;
      node.right = left;
      node.left = right;
      if (left != null) stack.push(left);
      if (right != null) stack.push(right);
    }
  }

  public void MirrorBinaryTreeRecursive(Node root) {
    if (root == null) return;

    if (root == null) return;
    Node tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    MirrorBinaryTreeRecursive(root.left);
    MirrorBinaryTreeRecursive(root.right);
  }
}
