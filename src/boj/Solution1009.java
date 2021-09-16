package boj;

import java.util.Scanner;

public class Solution1009 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < T; i++) {
        String[] inputs = sc.nextLine().split("\\s");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int calc = a;
        for (int j = 1; j < b; j++) {
          calc = calc * a % 10;
        }
        calc = calc % 10;
        System.out.println(calc == 0 ? 10 : calc);
      }
    }
  }
}
