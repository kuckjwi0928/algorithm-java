package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {
  private final static Map<Integer, String> MAPPING_TABLE = new LinkedHashMap<>();

  static {
    MAPPING_TABLE.put(1000, "M");
    MAPPING_TABLE.put(900, "CM");
    MAPPING_TABLE.put(500, "D");
    MAPPING_TABLE.put(400, "CD");
    MAPPING_TABLE.put(100, "C");
    MAPPING_TABLE.put(90, "XC");
    MAPPING_TABLE.put(50, "L");
    MAPPING_TABLE.put(40, "XL");
    MAPPING_TABLE.put(10, "X");
    MAPPING_TABLE.put(9, "IX");
    MAPPING_TABLE.put(5, "V");
    MAPPING_TABLE.put(4, "IV");
    MAPPING_TABLE.put(1, "I");
  }

  public static void main(String[] args) {
    System.out.println(new IntegerToRoman().intToRoman(3));
    System.out.println(new IntegerToRoman().intToRoman(4));
    System.out.println(new IntegerToRoman().intToRoman(9));
    System.out.println(new IntegerToRoman().intToRoman(58));
    System.out.println(new IntegerToRoman().intToRoman(1994));
    System.out.println(new IntegerToRoman().intToRoman(20));
  }

  public String intToRoman(int num) {
    StringBuilder builder = new StringBuilder();

    for (int mapping : MAPPING_TABLE.keySet()) {
      while (num >= mapping) {
        builder.append(MAPPING_TABLE.get(mapping));
        num -= mapping;
      }
    }

    return builder.toString();
  }
}
