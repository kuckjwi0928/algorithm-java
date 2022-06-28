package programmers.kit;

import java.math.BigInteger;

public class Rectangle {
  // https://programmers.co.kr/learn/courses/30/lessons/62048
  public static void main(String[] args) {
    System.out.println(new Rectangle().solution(8, 12));
  }

  public long solution(int w, int h) {
    return (long) w * h - (w + h - gcd(w, h));
  }

  private long gcd(long a, long b) {
    return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
  }
}
