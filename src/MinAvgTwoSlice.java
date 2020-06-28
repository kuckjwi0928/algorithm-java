public class MinAvgTwoSlice {
  public static void main(String[] args) {
    System.out.println(MinAvgTwoSlice.solution(new int[]{4,2,2,5,1,5,8}));
  }

  private static int solution(int[] A) {
    double min = (A[0] + A[1]) / 2d;
    int idx = 0;
    for (int i = 2; i < A.length; i++) {
      double avg = (A[i - 2] + A[i - 1] + A[i]) / 3d;
      if (min > avg) {
        min = avg;
        idx = i - 2;
      }
      avg = (A[i - 1] + A[i]) / 2d;
      if (min > avg) {
        min = avg;
        idx = i - 1;
      }
    }
    return idx;
  }
}
