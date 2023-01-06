package boj;

import java.util.*;

public class Solution1764 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      Set<String> sets = new HashSet<>();
      for (int i = 0; i < n; i++) {
        sets.add(scanner.next());
      }
      List<String> results = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        String name = scanner.next();
        if (sets.contains(name)) {
          results.add(name);
        }
      }
      results.sort(String::compareTo);
      System.out.println(results.size());
      for (String s : results) {
        System.out.println(s);
      }
    }
  }
}
