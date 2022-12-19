package leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
  public static void main(String[] args) {
    System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
    System.out.println(new WordBreak().wordBreak("applepenapple", List.of("apple", "pen")));
    System.out.println(new WordBreak().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    final var dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        final var contains = wordDict.contains(s.substring(i, j));
        if (dp[i] && contains) {
          dp[j] = dp[i];
        }
      }
    }
    return dp[s.length()];
  }
}
