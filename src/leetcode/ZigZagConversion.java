package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
  public static void main(String[] args) {
    // PAYPALISHIRING
    System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    List<StringBuilder> rows = new ArrayList<>();

    for (int i = 0; i < Math.min(numRows, s.length()); i++) {
      rows.add(new StringBuilder());
    }

    int row = 0;
    boolean down = false;

    for (char c : s.toCharArray()) {
      rows.get(row).append(c);
      if (row == 0 || row == numRows - 1) {
        down = !down;
      };
      row += down ? 1 : -1;
    }

    return String.join("", rows);
  }
}
