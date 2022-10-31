package book;

import java.util.Arrays;

public class FindComponent {
  public static void main(String[] args) {
    System.out.println(new FindComponent().find(new int[]{8,3,7,9,2}, new int[]{5,7,9}));
  }

  public String find(int[] N, int[] M) {
    Arrays.sort(N);
    StringBuilder builder = new StringBuilder();
    for (int j : M) {
      if (binarySearch(N, 0, N.length, j) == -1) {
        builder.append("no ");
      } else {
        builder.append("yes ");
      }
    }
    return builder.toString().trim();
  }

  private int binarySearch(int[] N, int start, int end, int target) {
    if (end < start) {
      return -1;
    }

    int mid = (start + end) / 2;

    if (target < N[mid]) {
      return binarySearch(N, start, mid - 1, target);
    }

    if (target > N[mid]) {
      return binarySearch(N, mid + 1, end, target);
    }

    return N[mid];
  }
}
