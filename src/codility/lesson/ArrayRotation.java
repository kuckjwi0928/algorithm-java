package codility.lesson;

public class ArrayRotation {
  public static void main(String[] args) {
    ArrayRotation.solution(new int[]{3,8,9,7,6}, 3);
    ArrayRotation.solution(new int[]{0,0,0}, 1);
    ArrayRotation.solution(new int[]{1,2,3,4}, 4);
  }
  private static int[] solution(int[] A, int K) {
    int len = A.length;

    if (len < 1) {
      return A;
    }

    for (int i = 0; i < K; i++) {
      int last = A[len - 1];
      for (int j = len - 1; j >= 0; j--) {
        if (j == 0) {
          A[0] = last;
          break;
        }
        A[j] = A[j - 1];
      }
    }

    return A;
  }
}
