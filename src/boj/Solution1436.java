package boj;

import java.util.Scanner;

public class Solution1436 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int n = scan.nextInt();
      int endNumber = 666;
      int count = 1;
      while (count < n) {
        endNumber++;
        int digit = endNumber;
        while (digit != 0) {
          if (digit % 1000 == 666) {
            count++;
            break;
          }
          digit /= 10;
        }
      }
      System.out.println(endNumber);
    }
  }
}
