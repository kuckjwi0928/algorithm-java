package book;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = new int[]{7,5,9,0,3,1,6,2,4,8};
    new SelectionSort().sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      swap(arr, i, min);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
