package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int startRow = 0;
    int endRow = matrix.length - 1;
    int startCol = 0;
    int endCol = matrix[0].length - 1;
    while (startRow <= endRow && startCol <= endCol) {
      for (int i = startCol; i <= endCol; i++) {
        result.add(matrix[startRow][i]);
      }
      for (int i = startRow + 1; i < endRow; i++) {
        result.add(matrix[i][endCol]);
      }
      if (startRow != endRow) {
        for (int i = endCol; i >= startCol; i--) {
          result.add(matrix[endRow][i]);
        }
      }
      if (startCol != endCol) {
        for (int i = endRow - 1; i > startRow; i--) {
          result.add(matrix[i][startCol]);
        }
      }
      startRow += 1;
      endRow -= 1;
      startCol += 1;
      endCol -= 1;
    }
    return result;
  }
}
