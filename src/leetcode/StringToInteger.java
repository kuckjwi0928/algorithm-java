package leetcode;

public class StringToInteger {
  public static void main(String[] args) {
    System.out.println(new StringToInteger().myAtoi("   -42"));
    System.out.println(new StringToInteger().myAtoi("4193 with words"));
    System.out.println(new StringToInteger().myAtoi("words and 987"));
    System.out.println(new StringToInteger().myAtoi("-91283472332"));
    System.out.println(new StringToInteger().myAtoi("-2147483648"));
    System.out.println(new StringToInteger().myAtoi("3.14159"));
    System.out.println(new StringToInteger().myAtoi("3"));
    System.out.println(new StringToInteger().myAtoi(""));
    System.out.println(new StringToInteger().myAtoi("-"));
    System.out.println(new StringToInteger().myAtoi("+1"));
    System.out.println(new StringToInteger().myAtoi("-0012a42"));
    System.out.println(new StringToInteger().myAtoi("+-12"));
    System.out.println(new StringToInteger().myAtoi("21474836460"));
    System.out.println(new StringToInteger().myAtoi(" "));
  }

  public int myAtoi(String s) {
    if (s.trim().isEmpty()) {
      return 0;
    }

    char[] chars = s.trim().split("\\s")[0].toCharArray();

    boolean sign = !(chars[0] == '-');

    int index = 0;
    long sum = 0;

    for (char c : chars) {
      // ignore first
      if (index == 0 && (c == '-' || c == '+')) {
        index++;
        continue;
      }

      // break non number
      if (!(c >= '0' && c <= '9')) {
        break;
      }

      sum = sum * 10 + Character.getNumericValue(c);

      // break integer exceed
      if (sum >= Integer.MAX_VALUE) {
        break;
      }

      index++;
    }

    long result = sign ? sum : -sum;

    if (result <= Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    } else if (result >= Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) result;
  }
}
