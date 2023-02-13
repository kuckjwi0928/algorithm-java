package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2869
public class Solution2869 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int v = scanner.nextInt();
      System.out.println((int) Math.ceil((double) (v - b) / (a - b)));
    }
  }
}
