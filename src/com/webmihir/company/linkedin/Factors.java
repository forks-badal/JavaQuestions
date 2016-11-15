package com.webmihir.company.linkedin;

import java.util.LinkedList;
import java.util.List;


public class Factors {
  public List<String> factors(int n) {
    List<String> list = new LinkedList<>();

    if (n<=1) return list;

    list.add("1*" + n);

    findAllFactors(list, "", n);

    return list;
  }

  private void findAllFactors(List<String> list, String soFar, int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        list.add(soFar + i + "*" + n/i);
        findAllFactors(list, soFar+i+"*", n/i);
      }
    }
  }

  public void printFactors(int n) {
    System.out.println("Factors for " + n + ":");
    System.out.println("1*" + n);
    printAllFactors("", n);
  }

  private void printAllFactors(String soFar, int n) {
    if (n == 1) {
      System.out.println(soFar.substring(1));
      soFar = "";
    } else {
      for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
          printAllFactors(soFar + "*" + i + "*" + n/i, 1);
          printAllFactors(soFar + "*" + i, n/i);
        }
      }
    }
  }
}
