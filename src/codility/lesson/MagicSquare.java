package codility.lesson;

public class MagicSquare {
  public static void main(String[] args) {
    int[][] s = new int[][] {
      { 4, 9 ,2 },
      { 3, 5 ,7 },
      { 8, 1 ,5 }
    };
    System.out.println(MagicSquare.formingMagicSquare(s));
  }

  private static int formingMagicSquare(int[][] s) {
    int[][][] magicSquareCase = new int[][][] {
      {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
      {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
      {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
      {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
      {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
      {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
      {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
      {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
    };

    int minCost = Integer.MAX_VALUE;

    for (int i = 0; i < magicSquareCase.length; i++) {
      int cost = 0;
      for (int j = 0; j < s.length; j++) {
        for (int k = 0; k < s[j].length; k++) {
          cost = cost + Math.abs(magicSquareCase[i][j][k] - s[j][k]);
        }
      }
      minCost = Math.min(minCost, cost);
    }

    return minCost;
  }
}
