package boj;

import java.util.Scanner;

public class Solution1629 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println(solution(scan.nextInt(), scan.nextInt(), scan.nextInt()));
    }
  }

  public static long solution(int a, int b, int c) {
    if (b == 1) {
      return a % c;
    }

    long res = solution(a, b / 2, c);

    if (b % 2 == 0) {
      return (res * res) % c;
    }

    return (res * res % c) * a % c;
  }
}
