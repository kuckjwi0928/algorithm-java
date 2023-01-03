package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1676
public class Solution1676 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      System.out.println(n / 5 + n / 25 + n / 125);
    }
  }
}
