package codility.lesson;

public class MaxCounters {
  public static void main(String[] args) {
    MaxCounters.solution(5, new int[]{3,4,4,6,1,4,4});
  }
  private static int[] solution(int N, int[] A) {
    int[] counters = new int[N];
    int currentMax = 0;
    int lastMax = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] > N) {
        lastMax = currentMax;
        continue;
      }
      int index = A[i] - 1;
      if (counters[index] < lastMax) {
        counters[index] = lastMax;
      }
      counters[index] = counters[index] + 1;
      currentMax = Math.max(currentMax, counters[index]);
    }
    for (int i = 0; i < N; i++) {
      counters[i] = Math.max(lastMax, counters[i]);
    }
    return counters;
  }
}
