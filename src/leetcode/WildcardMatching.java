package leetcode;

import java.util.Arrays;

public class WildcardMatching {
  public static void main(String[] args) {
    System.out.println(new WildcardMatching().isMatch("aa", "a"));
    System.out.println(new WildcardMatching().isMatch("aa", "*"));
    System.out.println(new WildcardMatching().isMatch("cb", "?a"));
    System.out.println(new WildcardMatching().isMatch("acdcb", "a*c?b"));
    System.out.println(new WildcardMatching().isMatch("adceb", "*a*b"));
  }

  public boolean isMatch(String s, String p) {
    char[] c1 = s.toCharArray();
    char[] c2 = p.toCharArray();
    boolean[][] visited = new boolean[c1.length + 1][c2.length + 1];
    visited[0][0] = true;

    for (int i = 1; i <= c2.length; i++) {
      if (c2[i - 1] == '*') {
        visited[0][i] = visited[0][i - 1];
      }
    }

    for (int i = 1; i <= c1.length; i++) {
      for (int j = 1; j <= c2.length; j++) {
        if (c2[j - 1] == '?' || c2[j - 1] == c1[i - 1]) {
          visited[i][j] = visited[i - 1][j - 1];
        } else if (c2[j - 1] == '*') {
          visited[i][j] = visited[i - 1][j] || visited[i][j - 1];
        }
      }
    }

    return visited[c1.length][c2.length];
  }
}
