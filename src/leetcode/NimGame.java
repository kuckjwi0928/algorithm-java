package leetcode;

public class NimGame {
  public static void main(String[] args) {
    System.out.println(new NimGame().canWinNim(4));
  }

  public boolean canWinNim(int n) {
    return n % 4 != 0;
  }
}
