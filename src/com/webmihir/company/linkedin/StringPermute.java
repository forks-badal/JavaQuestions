package com.webmihir.company.linkedin;

public class StringPermute {
  public void permute(String s) {
    permute(s, "");
  }

  private void permute(String s, String sofar) {
    if (s.length() == 1) System.out.println(sofar + s);

    for (int i = 0; i < s.length(); i++) {
      permute(s.substring(0, i) + s.substring(i+1), sofar + s.charAt(i));
    }
  }
}
