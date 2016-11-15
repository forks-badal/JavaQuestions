package com.webmihir.company.linkedin;

public class RGBColorAssignment {
  /**
   * In this problem, we have several houses placed on a street.
   We'd like to paint each house either red, green, or blue.
   The amount of money it costs to paint a specific house a specific color varies (maybe the owner already has some old paint that he can use, or parts of his house are already painted that color).
   A house cannot be painted the same color as one of its neighbors
   The goal is to paint all of the houses for the minimum total cost.
   Write a function
   int paintHouses(int[][] costs)
   */
  public int paintHouses(int[][] costs) {
    int numColors = costs.length;
    int numHouses = costs[0].length;
    int[][] paints = new int[numColors][numHouses];

    for(int i = 0; i < numColors; i++) {
      paints[i][0] = costs[i][0];
    }

    for(int house = 1; house < numHouses; house++) {
      printArr(paints);
      System.out.println("----------");
      for (int color = 0; color < numColors; color++) {
        int bestSoFar = Integer.MAX_VALUE;
        for ( int i = 0; i < numColors; i++ ) {
          if (i == color) continue;
          bestSoFar = Math.min(bestSoFar, paints[i][house - 1]);
        }
        paints[color][house] = costs[color][house] + bestSoFar;
      }
    }

    printArr(paints);
    int minCost = Integer.MAX_VALUE;
    for (int color = 0; color < numColors; color++) {
      minCost = Math.min(minCost, paints[color][numHouses-1]);
    }

    return minCost;
  }

  private void printArr(int[][] arr) {
    for (int i = 0; i < arr[0].length; i++) {
      for(int j = 0; j < arr.length; j++) {
        System.out.print(arr[j][i] + "  ");
      }
      System.out.println();
    }
  }
}
