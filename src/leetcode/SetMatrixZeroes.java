package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    new SetMatrixZeroes().setZeroes(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    });
    new SetMatrixZeroes().setZeroes(new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
    });
  }

  public void setZeroes(int[][] matrix) {
    List<Integer> cols = new ArrayList<>();
    List<Integer> rows = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for (int row : rows) {
      Arrays.fill(matrix[row], 0);
    }

    for (int col : cols) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][col] = 0;
      }
    }
  }
}
