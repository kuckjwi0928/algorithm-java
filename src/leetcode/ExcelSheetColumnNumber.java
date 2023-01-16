package leetcode;

public class ExcelSheetColumnNumber {
  public static void main(String[] args) {
    System.out.println(new ExcelSheetColumnNumber().titleToNumber("A"));
    System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
  }

  public int titleToNumber(String columnTitle) {
    char[] chars = columnTitle.toCharArray();
    int result = 0;
    int multi = 1;
    for (int i = chars.length - 1; i >= 0; i--) {
      result += (chars[i] - 'A' + 1) * multi;
      multi *= 26;
    }
    return result;
  }
}
