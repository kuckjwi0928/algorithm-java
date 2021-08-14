package hackerrank.structure;

import java.util.List;

public class TwoDArray {
  public static void main(String[] args) {
    List<List<Integer>> list = List.of(
      List.of(1, 1, 1, 0, 0, 0),
      List.of(0, 1, 0, 0, 0, 0),
      List.of(1, 1, 1, 0, 0, 0),
      List.of(0, 0, 2, 4, 4, 0),
      List.of(0, 0, 0, 2, 0, 0),
      List.of(0, 0, 1, 2, 4, 0)
    );
    System.out.println(hourglassSum(list));
  }

  public static int hourglassSum(List<List<Integer>> arr) {
    int max = Integer.MIN_VALUE;
    int size = arr.size();

    for (int i = 0; i < size - 2; i++) {
      for (int j = 0; j < arr.get(i).size() - 2; j++) {
        int top = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2);
        int mid = arr.get(i + 1).get(j + 1);
        int bottom = arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
        max = Math.max(max, top + mid + bottom);
      }
    }

    return max;
  }
}
