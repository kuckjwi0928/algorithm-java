package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
  public static void main(String[] args) {
    new PermutationsII().permuteUnique(new int[]{1, 1, 2});
    new PermutationsII().permuteUnique(new int[]{3, 3, 0, 3});
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(nums);
    permute(visited, nums, new ArrayList<>(), results);
    return results;
  }

  public void permute(boolean[] visited, int[] nums, List<Integer> list, List<List<Integer>> results) {
    if (nums.length == list.size()) {
      results.add(new ArrayList<>(list));
      return;
    }
    int prev = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] || nums[i] == prev) {
        continue;
      }
      prev = nums[i];
      visited[i] = true;
      list.add(nums[i]);
      permute(visited, nums, list, results);
      list.remove(list.size() - 1);
      visited[i] = false;
    }
  }
}
