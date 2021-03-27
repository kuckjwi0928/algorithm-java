package codility;

public class GenomicRangeQuery {
  // A = 1, C = 2, G = 3, T = 4
  public static void main(String[] args) {
    GenomicRangeQuery.solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6});
  }
  private static int[] solution(String S, int[] P, int[] Q) {
    char[] strings = S.toCharArray();
    int[][] genomics = new int[3][strings.length + 1];
    int[] results = new int [P.length];

    for (int i = 0; i < strings.length; i++) {
      int a = 0;
      int c = 0;
      int g = 0;
      if (strings[i] == 'A') {
        a = 1;
      } else if (strings[i] == 'C') {
        c = 1;
      } else if (strings[i] == 'G') {
        g = 1;
      }
      genomics[0][i + 1] = genomics[0][i] + a;
      genomics[1][i + 1] = genomics[1][i] + c;
      genomics[2][i + 1] = genomics[2][i] + g;
    }

    for (int i = 0; i < P.length; i++) {
      int from = P[i];
      int to = Q[i] + 1;
      if (genomics[0][to] - genomics[0][from] > 0) {
        results[i] = 1;
      } else if (genomics[1][to] - genomics[1][from] > 0) {
        results[i] = 2;
      } else if (genomics[2][to] - genomics[2][from] > 0) {
        results[i] = 3;
      } else {
        results[i] = 4;
      }
    }

    return results;
  }
}
