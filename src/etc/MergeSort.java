package etc;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = new int[]{2,3,4,1,7};
    new MergeSort().mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private void mergeSort(int[] arr, int left, int right) {
    if (left == right) {
      return;
    }

    int mid = (left + right) / 2;

    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, mid, left, right);
  }

  private void merge(int[] arr, int mid, int left, int right) {
    int[] temp = new int[arr.length];

    int l = left;
    int r = mid + 1;
    int k = left;

    while (l <= mid && r <= right)  {
      if (arr[l] <= arr[r]) {
        temp[k++] = arr[l++];
      } else {
        temp[k++] = arr[r++];
      }
    }

    System.out.println(l + "," + mid + "," + r + "," + right);

    if (l > mid) {
      while(r <= right) {
        temp[k++] = arr[r++];
      }
    } else {
      while(l <= mid) {
        temp[k++] = arr[l++];
      }
    }

    if (right + 1 - left >= 0) {
      System.arraycopy(temp, left, arr, left, right + 1 - left);
    }
  }
}
