public class MissingInteger {
  public static void main(String[] args) {
    System.out.println(MissingInteger.solution(new int[]{1,2,3,4,5,6,200}));
  }
  private static int solution(int[] arr) {
    int len = arr.length;
    boolean[] possibles = new boolean[len + 1];
    for (int i = 0; i < len; i++) {
      if (arr[i] > 0 && arr[i] <= len) {
        possibles[arr[i]] = true;
      }
    }
    for (int i = 1; i <= len; i++) {
      if (!possibles[i]) {
        return i;
      }
    }
    return len + 1;
  }
}
