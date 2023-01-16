package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

  public static void main(String[] args) {
    System.out.println(new PascalsTriangleII().getRow(3));
    System.out.println(new PascalsTriangleII().getRow(0));
    System.out.println(new PascalsTriangleII().getRow(1));
  }
  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (i != 1 && j != 0 && j < i) {
          list.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
        } else {
          list.add(1);
        }
      }
      results.add(list);
    }
    return results.get(rowIndex);
  }
}
