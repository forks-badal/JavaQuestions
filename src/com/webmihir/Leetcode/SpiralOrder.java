package com.webmihir.Leetcode;

import java.util.LinkedList;
import java.util.List;


/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
  List<Integer> list = new LinkedList<>();
  if (matrix == null) return list;

  int max = matrix.length / 2;
  if (matrix.length % 2 != 0) max++;

  for (int i = 0; i < max; i++) {
    printRound(matrix, i, list);
  }
  return list;
}

  private void printRound(int[][] matrix, int round, List<Integer> list) {
    int maxRows = matrix.length - round;
    int maxCols = matrix[round].length - round;

    //Right
    for (int i = round; i < maxCols; i++) {
      list.add(matrix[round][i]);
    }

    //Down
    for (int i = round+1; i < maxRows; i++) {
      list.add(matrix[i][maxCols - 1]);
    }

    //Left
    if( round + 1 != maxRows) {
      for (int i = maxCols - 1; i >= round; i--) {
        list.add(matrix[maxRows - 1][i]);
      }
    }

    //Up
    for (int i = maxRows-1; i > round; i--) {
      list.add(matrix[i][round]);
    }
  }
}
