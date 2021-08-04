package etc;

public class BinarySearch {
  public static void main(String[] args) {
    int arr[] = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
    int index = binarySearch(arr, 19, 0, arr.length);
    System.out.println(arr[index]);
  }

  private static int binarySearch(int arr[], int target, int low, int high) {
    if (high < low) {
      return -1;
    }

    int mid = (low + high) / 2;

    if (arr[mid] > target) {
      return binarySearch(arr, target, low, mid - 1);
    } else if (arr[mid] < target) {
      return binarySearch(arr, target, mid + 1, high);
    }

    return mid;
  }
}
