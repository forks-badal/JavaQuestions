package com.webmihir.company.linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class FallingLeaves {
  /**
   * Given a tree, print nodes the leaf nodes, followed by the next set of leaf nodes, etc.
   * For example, given a tree such as :
   *              5
   *            /   \
   *           3    10
   *         /  \  /  \
   *        2   1  7  8
   *       /
   *      0
   *
   * You would print:
   * 0 1 7 8
   * 2 10
   * 3
   * 5
   */
  public void fallingLeaves(Node root) {
    if (root == null) return;

    Map<Integer, List<Node>> map = new HashMap<>();
    generateMappings(root, map);

    int maxLevel = map.keySet().size();
    for (int i = 1; i <= maxLevel; i++) {
      for (Node node : map.get(i)) {
        System.out.print(node.value + " ");
      }
      System.out.println();
    }
  }

  private int generateMappings(Node root, Map<Integer, List<Node>> map) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      addToMap(1, root, map);
      return 1;
    }

    int level = 1 + Math.max(generateMappings(root.left, map), generateMappings(root.right, map));
    addToMap(level, root, map);
    return level;
  }

  private void addToMap(int level, Node node, Map<Integer, List<Node>> map) {
    if (!map.containsKey(level)) {
      map.put(level, new LinkedList<Node>());
    }
    map.get(level).add(node);
  }

  public static class Node {
    public int value;
    public Node left;
    public Node right;

    public Node() {

    }
  }
}
