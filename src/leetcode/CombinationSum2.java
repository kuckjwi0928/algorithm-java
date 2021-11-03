package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

  public static void main(String[] args) {
    System.out.println(new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
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
      if (candidate > target || (i != start && candidates[i] == candidates[i - 1])) {
        continue;
      }
      cur.add(candidate);
      combination(candidates, i + 1, target - candidate, cur, result);
      cur.remove(cur.size() - 1);
    }
  }
}
