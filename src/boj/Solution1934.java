package boj;

import java.util.Scanner;

public class Solution1934 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int n = scan.nextInt();

      for (int i = 0; i < n; i++) {
        int a = Integer.parseInt(scan.next());
        int b = Integer.parseInt(scan.next());
        System.out.println(a * b / gcd(a, b));
      }
    }
  }

  private static int gcd(int a, int b){
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
