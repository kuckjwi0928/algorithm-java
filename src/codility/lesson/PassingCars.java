package codility.lesson;

public class PassingCars {
  public static void main(String[] args) {
    System.out.println(PassingCars.solution(new int[]{0, 1, 0, 1, 1}));
  }
  public static int solution(int[] A) {
    int result = 0;
    int zero = 0;
    for (int i = 0, len = A.length; i < len; i++) {
      if (A[i] == 0) {
        zero++;
        continue;
      }
      result += zero;
    }
    if (result < 0 || result > 1000000000) {
      return -1;
    }
    return result;
  }
}
