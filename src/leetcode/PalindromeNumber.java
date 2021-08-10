package leetcode;

public class PalindromeNumber {
  public static void main(String[] args) {
    System.out.println(new PalindromeNumber().isPalindrome(121));
    System.out.println(new PalindromeNumber().isPalindrome(-121));
  }

  public boolean isPalindrome(int x) {
    return Integer.toString(x).equals(new StringBuilder().append(x).reverse().toString());
  }
}
