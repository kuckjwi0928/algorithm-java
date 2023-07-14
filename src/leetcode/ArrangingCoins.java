package leetcode;

public class ArrangingCoins {
  public static void main(String[] args) {
    System.out.println(new ArrangingCoins().arrangeCoins(5));
    System.out.println(new ArrangingCoins().arrangeCoins(8));
  }

  public int arrangeCoins(int n) {
    long i = 0;
    for (i = 1; i * (i + 1) / 2 <= n; i++);
    return (int) i - 1;
  }
}
