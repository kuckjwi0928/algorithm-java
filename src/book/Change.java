package book;

public class Change {
  public static void main(String[] args) {
    System.out.println(solution(1260, new int[]{500, 100, 50, 10}));
  }

  private static int solution(int n, int[] coins) {
    int remain = n;
    int count = 0;
    for (int coin : coins) {
      count = count + (remain / coin);
      remain = remain % coin;
    }
    return count;
  }
}
