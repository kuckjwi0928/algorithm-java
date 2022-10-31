package hackerrank.algorithms;

import java.math.BigInteger;

public class ExtraLongFactorials {
  public static void main(String[] args) {
    extraLongFactorials(25);
  }

  public static void extraLongFactorials(int n) {
    BigInteger bigInteger = BigInteger.ONE;
    for (int i = 1; i <= n; i++) {
      bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
    }
    System.out.println(bigInteger);
  }
}
