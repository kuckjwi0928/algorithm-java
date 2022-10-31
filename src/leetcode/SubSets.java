package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
  public static void main(String[] args) {
    System.out.println(new SubSets().subsets(new int[]{1,2,3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    solution(results, new LinkedList<>(), nums, 0);
    return results;
  }

  private void solution(List<List<Integer>> results, List<Integer> output, int[] nums, int index) {
    if (index == nums.length) {
      results.add(new ArrayList<>(output));
      return;
    }
    output.add(nums[index]);
    solution(results, output, nums, index + 1);
    output.remove(output.size() - 1);
    solution(results, output, nums, index + 1);
  }
}
