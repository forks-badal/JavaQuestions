package com.webmihir.Topcoder;

import java.util.Arrays;


public class DynamicProgramming {


   /*
   * https://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
   *
   * Problem Statement
   *
   * A sequence of numbers is called a zig-zag sequence if the differences between successive numbers
   * strictly alternate between positive and negative. The first difference (if one exists) may be either
   * positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.
   *
   * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately
   * positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because
   * its first two differences are positive and the second because its last difference is zero.
   *
   * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
   *
   *
   * Definition
   *
   *
   * Method signature:	int longestZigZag(int[] sequence)
   *
   * Constraints
   * -	sequence contains between 1 and 50 elements, inclusive.
   * -	Each element of sequence is between 1 and 1000, inclusive.
   * */
   public int longestZigZag(int[] sequence) {
     if (sequence == null || sequence.length == 0) {
       return 0;
     }

     int res = 1;
     int[][] Z = new int[sequence.length][2];
     Z[0][0] = 1;
     Z[0][1] = 1;

     for (int i = 1; i < sequence.length; i++) {
       for (int j = i-1; j >= 0; j--) {
         if(sequence[j] < sequence[i]) {
           Z[i][0] = Math.max(Z[j][1]+1,Z[i][0]);
         }

         if(sequence[j] > sequence[i]) {
           Z[i][1] = Math.max(Z[j][0]+1, Z[i][1]);
         }

//         System.out.println("i=" + i + ", j=" + j);
//         System.out.println("-------------------");
//         for (int k = 0; k < sequence.length; k++) {
//           System.out.println("Z[" + k + "] = " + Z[k][0] + "\t" + Z[k][1]);
//         }
//         System.out.println("===================");
       }
       res = Math.max(res, Math.max(Z[i][0], Z[i][1]));
     }

     return res;
   }

  /**
   * Imagine you have a collection of N wines placed next to each other on a shelf.
   * Let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively.
   * The price of the ith wine is Pi (prices of different wines can be different).
   *
   * Because the wines get better every year, supposing today is the year 1,
   * on year y the price of the ith wine will be y*Pi, i.e. y-times the value that current year.
   *
   * You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year.
   * One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf
   * and you are not allowed to reorder the wines on the shelf
   * (i.e. they must stay in the same order as they are in the beginning).
   *
   * You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?"
   */
  public int maxProfitFromWine(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int[][] computedPrice = new int[prices.length][prices.length];
    for (int i = 0; i < prices.length; i++) {
      Arrays.fill(computedPrice[i], -1);
    }
    return maxProfitFromWine(prices, computedPrice, 0, prices.length - 1);
  }

  private int maxProfitFromWine(int[] prices, int[][] computedPrice, int start, int end) {
    if (start > end) {
      return 0;
    }

    if (computedPrice[start][end] != -1) {
      return computedPrice[start][end];
    }

    int year = prices.length - (end-start);

    computedPrice[start][end] = Math.max(maxProfitFromWine(prices, computedPrice, start+1, end) + (year * prices[start]),
        maxProfitFromWine(prices, computedPrice, start, end-1) + (year * prices[end]));
    return computedPrice[start][end];
  }

  /**
   * There are n cards and each one of them has a positive integer that is less than 1000 written on it.
   * The cards are aligned next to each other. Martin has come up with a new game:
   * There are n - 2 number of turns to be exetuted in it. In each turn a card from the card sequence is removed
   * excluding the first and the last card. For every removed card there are points given, which are calculated by
   * multiplying the number written on the card with the sum of the numbers written on the 2 cards next to it.
   * Eventually there are only 2 cards left(the first and the last).
   *
   * Write a program game which finds the maximum amount of points which can be recieved by playing the game.
   */
  public int maxPoints(int[] cards) {
    return 0;
  }
}
