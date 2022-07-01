package programmers.kit;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/77485
public class RotateMatrix {
  public static void main(String[] args) {
    new RotateMatrix().solution(6, 6, new int[][]{{2,2,5,4}});
    new RotateMatrix().solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    new RotateMatrix().solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    new RotateMatrix().solution(3, 3, new int[][]{{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}});
    new RotateMatrix().solution(100, 97, new int[][]{{1,1,100,97}});
  }

  public int[] solution(int rows, int columns, int[][] queries) {
    List<Integer> answers = new ArrayList<>();
    int[][] matrix = new int[rows][columns];
    int num = 1;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = num;
        num++;
      }
    }

    int min = Integer.MAX_VALUE;

    for (int[] query : queries) {
      int q1 = query[0] - 1;
      int q2 = query[1] - 1;
      int q3 = query[2] - 1;
      int q4 = query[3] - 1;

      int temp = matrix[q1][q2];

      // left
      for (int i = q1; i < q3; i++) {
        matrix[i][q2] = matrix[i + 1][q2];
        min = Math.min(min, matrix[i + 1][q2]);
      }

      // bottom
      for (int i = q2; i < q4; i++) {
        matrix[q3][i] = matrix[q3][i + 1];
        min = Math.min(min, matrix[q3][i + 1]);
      }

      // right
      for (int i = q3 - 1; i >= q1; i--) {
        matrix[i + 1][q4] = matrix[i][q4];
        min = Math.min(min, matrix[i][q4]);
      }

      // top
      for (int i = q4; i > q2 + 1; i--) {
        matrix[q1][i] = matrix[q1][i-1];
        min = Math.min(min, matrix[q1][i-1]);
      }

      matrix[q1][q2 + 1] = temp;
      min = Math.min(min, matrix[q1][q2 + 1]);
      answers.add(min);
      min = Integer.MAX_VALUE;
    }

    return answers.stream().mapToInt(i -> i).toArray();
  }
}
