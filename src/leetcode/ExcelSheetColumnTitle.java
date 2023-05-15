package leetcode;

public class ExcelSheetColumnTitle {
  public static void main(String[] args) {
    System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
    System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
  }

  public String convertToTitle(int n) {
    var builder = new StringBuilder();
    while (n > 0) {
      n--;
      var curr = n % 26;
      n /= 26;
      builder.append((char) (curr + 'A'));
    }
    return builder.reverse().toString();
  }
}
