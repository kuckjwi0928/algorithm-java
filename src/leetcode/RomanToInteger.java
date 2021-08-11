package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {
  private final static Map<Character, Integer> MAPPING_TABLE = new LinkedHashMap<>();

  static {
    MAPPING_TABLE.put('M', 1000);
    MAPPING_TABLE.put('D', 500);
    MAPPING_TABLE.put('C', 100);
    MAPPING_TABLE.put('L', 50);
    MAPPING_TABLE.put('X', 10);
    MAPPING_TABLE.put('V', 5);
    MAPPING_TABLE.put('I', 1);
  }

  public static void main(String[] args) {
    System.out.println(new RomanToInteger().romanToInt("III"));
    System.out.println(new RomanToInteger().romanToInt("IV"));
    System.out.println(new RomanToInteger().romanToInt("IX"));
    System.out.println(new RomanToInteger().romanToInt("LVIII"));
    System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
  }

  public int romanToInt(String s) {
    char[] chars = s.toCharArray();

    int prev = 0;
    int sum = 0;

    for (char c : chars) {
      int cur = MAPPING_TABLE.get(c);

      if (prev < cur) {
        sum += cur - prev * 2;
      } else {
        sum += cur;
      }

      prev = cur;
    }

    return sum;
  }
}
