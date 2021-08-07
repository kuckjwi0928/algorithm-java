package leetcode;

public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(-123));
    System.out.println(new ReverseInteger().reverse(123));
    System.out.println(new ReverseInteger().reverse(120));
    System.out.println(new ReverseInteger().reverse(0));
    System.out.println(new ReverseInteger().reverse(-2147483648));
    System.out.println(new ReverseInteger().reverse(1534236469));
  }

  public int reverse(int x) {
    long reversed = 0;
    while(x != 0) {
      int digit = x % 10;
      reversed = reversed * 10 + digit;
      if (reversed >= Integer.MAX_VALUE || reversed <= Integer.MIN_VALUE) {
        return 0;
      }
      x /= 10;
    }
    return (int) reversed;
  }
}
