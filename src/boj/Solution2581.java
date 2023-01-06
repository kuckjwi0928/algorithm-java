package boj;

import java.util.Scanner;

public class Solution2581 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int m = scanner.nextInt();
      int n = scanner.nextInt();
      int min = 10001;
      int sum = 0;
      for (int i = m; i <= n; i++) {
        if (i == 1) {
          continue;
        }
        if (isPrime(i)) {
          sum += i;
          if (min == 10001) {
            min = i;
          }
        }
      }
      if (min == 10001) {
        System.out.println(-1);
      } else {
        System.out.println(sum);
        System.out.println(min);
      }
    }
  }

  public static boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
