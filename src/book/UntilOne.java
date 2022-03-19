package book;

public class UntilOne {
  public static void main(String[] args) {
    System.out.println(solution(25, 5));
//    System.out.println(solution(17, 4));
  }

  public static int solution(int N, int K) {
    int count = 0;

    while (true) {
      int target = (N / K) * K;
      count += (N - target);
      N = target;
      if (target < K) {
        break;
      }
      count++;
      N /= K;
    }

    count += N - 1;

    return count;
  }
}
