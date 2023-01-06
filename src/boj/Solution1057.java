package boj;

import java.util.Scanner;

public class Solution1057 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int n = scan.nextInt();
      int a = scan.nextInt();
      int b = scan.nextInt();
      int count = 0;

      while (a != b) {
        a -= a / 2;
        b -= b / 2;
        count++;
      }

      System.out.println(count);
    }
  }
}
