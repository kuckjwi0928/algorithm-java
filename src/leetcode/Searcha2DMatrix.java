package leetcode;

public class Searcha2DMatrix {
  public static void main(String[] args) {
    System.out.println(new Searcha2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
    System.out.println(new Searcha2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int value = matrix[mid / n][mid % n];
      if (value == target) {
        return true;
      } else if (value < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
