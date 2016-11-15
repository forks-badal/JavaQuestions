package com.webmihir.Leetcode;

import java.util.List;
import java.util.Stack;


/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
  public int calculate(String s) {
    if (s == null) return 0;
    int result = 0;
    int number = 0;
    int sign = 1;//positive
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      switch(ch) {
        case ' ':
          break;
        case '+':
          result += (number * sign);
          number = 0;
          sign = 1;
          break;
        case '-':
          result += (number * sign);
          number = 0;
          sign = -1;
          break;
        case '(':
          stack.push(result);
          stack.push(sign);
          result = 0;
          sign = 1;
          break;
        case ')':
          result += (number * sign);
          result *= stack.pop();
          result += stack.pop();
          number = 0;
          break;
        default:
          number = (number*10) + (ch - '0');
      }
    }
    return result + (sign * number);
  }
}
