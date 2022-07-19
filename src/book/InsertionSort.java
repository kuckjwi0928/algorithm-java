package book;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = new int[]{7,5,9,0,3,1,6,2,4,8};
    new InsertionSort().sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
        }
      }
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
