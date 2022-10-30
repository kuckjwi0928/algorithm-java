package book;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayElementChange {
  public static void main(String[] args) {
    System.out.println(new ArrayElementChange().max(new int[]{1,2,5,4,3}, new int[]{5,5,6,6,5}));
  }

  public int max(int[] arr, int[] arr2) {
    Arrays.sort(arr);
    List<Integer> list = Arrays.stream(arr2).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

    for (int i = 0; i < 3; i++) {
      if (arr[i] > list.get(i)) {
        break;
      }
      arr[i] = list.get(i);
    }

    return Arrays.stream(arr).sum();
  }
}
