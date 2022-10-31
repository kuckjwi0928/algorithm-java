package book;

import java.util.Arrays;

public class MakeRiceCake {
  public static void main(String[] args) {
    System.out.println(new MakeRiceCake().solution(new int[]{19, 15, 10, 17}, 6));
  }

  public int solution(int[] heights, int height) {
    Arrays.sort(heights);
    int start = 0;
    int end = heights.length - 1;
    int result = 0;
    while (start <= end) {
      int total = 0;
      int mid = (start + end) / 2;
      for (int h : heights) {
        if (h > heights[mid]) {
          total += h - heights[mid];
        }
      }
      if (total < height) {
        end = mid - 1;
      } else {
        result = heights[mid];
        start = mid + 1;
      }
    }
    return result;
  }
}
