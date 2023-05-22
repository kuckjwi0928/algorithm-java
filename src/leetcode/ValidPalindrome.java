package leetcode;

public class ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(new ValidPalindrome().isPalindrome("0P"));
    System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
  }

  public boolean isPalindrome(String s) {
    var origin = s.replaceAll("[^[a-zA-Z|0-9]]", "");
    return origin.equalsIgnoreCase(new StringBuilder().append(origin).reverse().toString());
  }
}
