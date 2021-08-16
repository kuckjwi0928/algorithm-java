package etc;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = new int[]{5,4,6,1,2,3};
    new QuickSort().quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public void quickSort(int[] arr, int left, int right){
    if (left >= right) {
      return;
    }

    int i = left;
    int j = right;
    int pivot = arr[(left + right) / 2]; // fix the pivot

    do {
      // find greater than pivot
      while (arr[i] < pivot) {
        i++;
      }
      // find less than pivot
      while (arr[j] > pivot) {
        j--;
      }
      if (i <= j) {
        swap(arr, i, j);
        i++;
        j--;
      }
    } while (i <= j);

    quickSort(arr, left, j);
    quickSort(arr, i, right);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
