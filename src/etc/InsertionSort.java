package etc;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = new int[]{7,5,9,0,3,1,6,2,4,8};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j - 1] > arr[j]) {
          int temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        } else {
          break;
        }
      }
    }
  }
}
