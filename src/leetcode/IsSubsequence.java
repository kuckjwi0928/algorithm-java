package leetcode;

public class IsSubsequence {
  public static void main(String[] args) {
    System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
  }

  public boolean isSubsequence(String s, String t) {
    if (s.length() > t.length()) {
      return false;
    }
    var i = 0;
    for (var c : t.toCharArray()) {
      if (i < s.length() && c == s.charAt(i)) {
        i++;
      }
    }
    return i == s.length();
  }
}
