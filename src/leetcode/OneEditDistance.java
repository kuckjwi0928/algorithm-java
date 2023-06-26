package leetcode;

// https://leetcode.com/problems/one-edit-distance/
public class OneEditDistance {
  public static void main(String[] args) {
    System.out.println(new OneEditDistance().isOneEditDistance("ab", "acb"));
    System.out.println(new OneEditDistance().isOneEditDistance("", ""));
    System.out.println(new OneEditDistance().isOneEditDistance("bbb", "abc"));
  }

  public boolean isOneEditDistance(String s, String t) {
    var n = s.length();
    var m = t.length();
    if (n > m) {
      return isOneEditDistance(t, s);
    }
    if (m - n > 1) {
      return false;
    }
    for (var i = 0; i < n; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (n == m) {
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else {
          return s.substring(i).equals(t.substring(i + 1));
        }
      }
    }
    return n + 1 == m;
  }
}
