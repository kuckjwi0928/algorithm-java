package book;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = new int[]{5,6,7,8,1,2,3,4};
    new QuickSort().quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
  public void quickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivot = start;
    int left = start + 1;
    int right = end;
    while (left <= right) {
      while (left <= end && arr[left] <= arr[pivot]) {
        left++;
      }
      while (right > start && arr[right] >= arr[pivot]) {
        right--;
      }
      if (left > right) {
        int temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;
      } else {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
      quickSort(arr, start, right - 1);
      quickSort(arr, right + 1, end);
    }
  }
}
