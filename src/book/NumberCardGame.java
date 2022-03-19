package book;

public class NumberCardGame {
  public static void main(String[] args) {
    System.out.println(solution(new int[][]{
            {3, 1, 2},
            {4, 1, 4},
            {2, 2, 2},
    }));
    System.out.println(solution(new int[][]{
            {7, 3, 1, 8},
            {3, 3, 3, 4},
    }));
  }

  public static int solution(int[][] nums) {
    int max = 0;
    for (int[] num : nums) {
      int min = Integer.MAX_VALUE;
      for (int i : num) {
        min = Math.min(min, i);
      }
      max = Math.max(max, min);
    }
    return max;
  }
}
