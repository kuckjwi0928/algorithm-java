package codility.exercise;

public class FloodDepth {
  public static void main(String[] args) {
    System.out.println(new FloodDepth().solution(new int[]{1,3,2,1,2,1,5,3,3,4,2}));
    System.out.println(new FloodDepth().solution(new int[]{3,1,10,4,20}));
    System.out.println(new FloodDepth().solution(new int[]{3,1,2}));
    System.out.println(new FloodDepth().solution(new int[]{5,8}));
  }

  public int solution(int[] A) {
    int result = 0;

    int high = 0;
    int row = 0;

    for (int i = 1; i < A.length; i++) {
      int currentValue = A[i];
      int leftValue = A[high];
      int rightValue = A[row];
      if (currentValue > leftValue) {
        result = Math.max(leftValue - rightValue, result);
        high = i;
        row = high;
      } else if (currentValue > rightValue) {
        result = Math.max(currentValue - rightValue, result);
      } else {
        row = i;
      }
    }

    return result;
  }
}
