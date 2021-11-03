package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    System.out.println(new CombinationSum().combinationSum(new int[]{2,3,5}, 8));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    combination(candidates, 0, target, new ArrayList<>(), result);
    return result;
  }

  private void combination(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> result) {
    if (target == 0) {
      result.add(List.copyOf(cur));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (candidate <= target) {
        cur.add(candidate);
        combination(candidates, i, target - candidate, cur, result);
        cur.remove(cur.size() - 1);
      }
    }
  }
}
