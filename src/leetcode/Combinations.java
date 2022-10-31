package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  public static void main(String[] args) {
    new Combinations().combine(4, 2);
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> results = new ArrayList<>();
    solution(results, new ArrayList<>(), n, k, 1);
    return results;
  }

  private void solution(List<List<Integer>> results, List<Integer> outputs, int n, int k, int index) {
    if (outputs.size() == k) {
      results.add(new ArrayList<>(outputs));
      return;
    }
    for (int i = index; i <= n; i++) {
      outputs.add(i);
      solution(results, outputs, n, k, i + 1);
      outputs.remove(outputs.size() - 1);
    }
  }
}
