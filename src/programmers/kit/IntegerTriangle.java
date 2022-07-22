package programmers.kit;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class IntegerTriangle {
  public static void main(String[] args) {
    IntegerTriangle it = new IntegerTriangle();
    System.out.println(it.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
  }

  public int solution(int[][] arr) {
    for (int i = arr.length - 2; i >= 0; i--) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
      }
    }
    return arr[0][0];
  }
}
