package hackerrank.algorithms;

import java.util.List;

public class NonDivisibleSubset {
  public static void main(String[] args) {
    System.out.println(nonDivisibleSubset(3, List.of(1, 7, 2, 4)));
  }

  public static int nonDivisibleSubset(int k, List<Integer> s) {
    int[] remainders = new int[k];
    for (int i : s) {
      remainders[i % k]++;
    }
    int count = Math.min(remainders[0], 1);
    for (int i = 1; i <= k / 2; i++) {
      if (i != k - i) {
        count += Math.max(remainders[i], remainders[k - i]);
      }
    }
    if (k % 2 == 0) {
      count++;
    }
    return count;
  }
}
