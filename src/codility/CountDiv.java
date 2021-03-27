package codility;

public class CountDiv {
  public static void main(String[] args) {
    System.out.println(CountDiv.solution(6, 11, 2));
  }

  private static int solution(int A, int B, int K) {
    return A % K != 0 ? B / K - A / K : (B / K - A / K) + 1;
  }
}
