package book;

import java.util.Arrays;

public class TopToDown {
  public static void main(String[] args) {
    new TopToDown().solution(new int[]{15,27,12});
  }

  public void solution(int[] arr) {
    Arrays.sort(arr);
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.println(arr[i]);
    }
  }
}
