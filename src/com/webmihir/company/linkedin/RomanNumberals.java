package com.webmihir.company.linkedin;

public class RomanNumberals {
  public String toRomanNumerals(int number)
  {
    // Build up the number like making change.
    StringBuilder sb = new StringBuilder();
    for(RomanNumeral numeral : NUMERALS)
    {
      while(number >= numeral.value)
      {
        sb.append(numeral.representation);
        number -= numeral.value;
      }
    }
    return sb.toString();
  }

  public int fromRomanNumberal(String num) {
    int cnt = 0;
    int tmp = 0;

    for (int i = 0; i < num.length(); i++) {
      char ch = num.charAt(i);
      int val = romanToInt(ch);

      if (tmp > 0 && tmp < val) {
        cnt += (val - tmp);
        tmp = 0;
      }
      else {
        cnt += tmp;
        tmp = val;
      }

      if (i == num.length()-1) cnt += tmp;
    }
    return cnt;
  }

  private int romanToInt(char ch) {
    switch(ch) {
      case 'M': return 1000;
      case 'D': return 500;
      case 'C': return 100;
      case 'L': return 50;
      case 'X': return 10;
      case 'V': return 5;
      case 'I': return 1;
      default: return 0;
    }
  }

  public static class RomanNumeral
  {
    private RomanNumeral(String representation, int value)
    {
      this.representation = representation;
      this.value = value;
    }
    String representation;
    int value;
  };

  public static final RomanNumeral[] NUMERALS = {
      new RomanNumeral("M", 1000),
      new RomanNumeral("CM", 900),
      new RomanNumeral("D", 500),
      new RomanNumeral("CD", 400),
      new RomanNumeral("C", 100),
      new RomanNumeral("XC", 90),
      new RomanNumeral("L", 50),
      new RomanNumeral("XL", 40),
      new RomanNumeral("X", 10),
      new RomanNumeral("IX", 9),
      new RomanNumeral("V", 5),
      new RomanNumeral("IV", 4),
      new RomanNumeral("I", 1)
  };
}
