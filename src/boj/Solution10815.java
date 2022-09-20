package boj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution10815 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();

      Set<Integer> cards = new HashSet<>();

      for (int i = 0; i < n; i++) {
        cards.add(scanner.nextInt());
      }

      int m = scanner.nextInt();
      int[] results = new int[m];

      for (int i = 0; i < m; i++) {
        results[i] = cards.contains(scanner.nextInt()) ? 1 : 0;
      }

      System.out.println(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
  }
}
