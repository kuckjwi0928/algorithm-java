package boj;

import java.util.Scanner;

public class Solution14425 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      String[] strings = new String[n];
      for (int i = 0; i < n; i++) {
        strings[i] = scanner.next();
      }
      int count = 0;
      for (int i = 0; i < m; i++) {
        String s = scanner.next();
        for (int j = 0; j < n; j++) {
          if (s.equals(strings[j])) {
            count++;
            break;
          }
        }
      }
      System.out.println(count);
    }
  }
}
