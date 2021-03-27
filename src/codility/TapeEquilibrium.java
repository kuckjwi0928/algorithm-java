package codility;

public class TapeEquilibrium {
  public static void main(String[] args) {
    System.out.println(TapeEquilibrium.solution(new int[]{3,1,2,4,3}));
  }
  private static int solution(int[] A) {
    int baseLen = A.length;
    int[] left = new int[baseLen - 1];
    int[] right = new int[baseLen - 1];

    int sum = 0;

    for (int i = 0; i < baseLen - 1; i++) {
      sum = sum + A[i];
      left[i] = sum;
    }

    sum = 0;

    for (int i = baseLen - 1; i > 0; i--) {
      sum = sum + A[i];
      right[i - 1] = sum;
    }

    int temp = Math.abs(left[0] - right[0]);
    for (int i = 1; i < left.length; i++) {
      int abs = Math.abs(left[i] - right[i]);
      if (temp > abs) {
        temp = abs;
      }
    }
    return temp;
  }
}
