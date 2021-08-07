package leetcode;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("abb"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("bb"));
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccd"));
  }

  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expand(s, i, i);
      int len2 = expand(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
