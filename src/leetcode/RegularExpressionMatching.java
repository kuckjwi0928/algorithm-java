package leetcode;

public class RegularExpressionMatching {
  public static void main(String[] args) {
    System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
    System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
    System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
    System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
    System.out.println(new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
  }

  public boolean isMatch(String s, String p) {
    return s.matches(p);
  }
}
