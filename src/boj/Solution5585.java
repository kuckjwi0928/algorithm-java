package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/5585
public class Solution5585 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int money = 1000 - sc.nextInt();
      int[] coins = {500, 100, 50, 10, 5, 1};
      int count = 0;
      for (int coin : coins) {
        count += money / coin;
        money %= coin;
      }
      System.out.println(count);
    }
  }
}
