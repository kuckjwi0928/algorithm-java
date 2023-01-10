package hackerrank.kits;

import java.util.Arrays;
import java.util.List;

public class CountingSort {
  public static void main(String[] args) {
    System.out.println(countingSort(List.of(1,1,3,2,1)));
  }
  public static List<Integer> countingSort(List<Integer> arr) {
    int[] counting = new int[100];
    for (Integer i : arr) {
      counting[i]++;
    }
    return Arrays.stream(counting).boxed().toList();
  }
}
