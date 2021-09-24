package etc;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = new int[]{7,5,9,0,3,1,6,2,4,8};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        // > Ascending
        // < Descending
        if (arr[minIndex] > arr[j]) {
          minIndex = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }
}
