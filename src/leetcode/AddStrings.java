package leetcode;

public class AddStrings {
  public static void main(String[] args) {
    final var solution = new AddStrings();
    System.out.println(solution.addStrings("11", "123"));
    System.out.println(solution.addStrings("1", "9"));
  }

  public String addStrings(String num1, String num2) {
    final var chars1 = num1.toCharArray();
    final var chars2 = num2.toCharArray();
    final var result = new StringBuilder();
    var carry = 0;
    var i = chars1.length - 1;
    var j = chars2.length - 1;
    while (i >= 0 || j >= 0) {
      var sum = carry;
      if (i >= 0) {
        sum += chars1[i--] - '0';
      }
      if (j >= 0) {
        sum += chars2[j--] - '0';
      }
      result.append(sum % 10);
      carry = sum / 10;
    }
    if (carry > 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }
}
