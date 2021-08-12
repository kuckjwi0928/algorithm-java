package etc;

import java.util.*;
import java.util.stream.Collectors;

public class PowerSet {
  public static void main(String[] args) {
    boolean[] visited = new boolean[6];

    new PowerSet().powerSet(new int[]{1,0,-1,0,-2,2}, 0, visited);
    new PowerSet().powerSetForBit(new int[]{1,2,3});
  }

  public void powerSet(int[] arr, int index, boolean[] visited) {
    Arrays.sort(arr);

    if (index == arr.length) {
      for (int i = 0; i < arr.length; i++) {
        if (visited[i]) {
          System.out.print(arr[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    visited[index] = false;
    powerSet(arr, index + 1, visited);
    visited[index] = true;
    powerSet(arr, index + 1, visited);
  }

  public void powerSetForBit(int[] arr) {
    for (int i = 0; i < 1 << arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if ((i & 1 << j) != 0) {
          System.out.print(arr[j] + " ");
        }
      }
      System.out.println();
    }
  }
}
