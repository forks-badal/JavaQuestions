package com.webmihir;

import com.webmihir.PiE.Recursion;
import org.testng.annotations.DataProvider;


public class DataProviderSrc {

  private static Recursion r = new Recursion();

  @DataProvider(name = "PiERecursion")
  public static Object[][] getRecursion() {
    return new Object[][]{{r}};
  }
}
