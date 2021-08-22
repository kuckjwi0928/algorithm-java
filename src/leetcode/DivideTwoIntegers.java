package leetcode;

public class DivideTwoIntegers {
  public static void main(String[] args) {
    System.out.println(new DivideTwoIntegers().divide(10, 3));
    System.out.println(new DivideTwoIntegers().divide(1, 1));
    System.out.println(new DivideTwoIntegers().divide(0, 1));
    System.out.println(new DivideTwoIntegers().divide(7, -3));
    System.out.println(new DivideTwoIntegers().divide(-1, -1));
    System.out.println(new DivideTwoIntegers().divide(1, -1));
    System.out.println(new DivideTwoIntegers().divide(1, -500));
    System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
    System.out.println(new DivideTwoIntegers().divide(-2147483648, 2));
    System.out.println(new DivideTwoIntegers().divide(-2147483648, -2));
  }

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    boolean sign = (dividend >= 0) == (divisor >= 0);

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    int divide = dividend - divisor;
    int count = 0;

    while (divide > -1){
      divide -= divisor;
      count++;
    }

    return sign ? count : -count ;
  }
}
