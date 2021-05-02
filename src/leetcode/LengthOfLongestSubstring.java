package leetcode;

import java.util.*;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
  }

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty() || s.length() == 1) {
      return s.length();
    }

    char[] chars = s.toCharArray();

    int len = chars.length;
    int p1 = 0;
    int p2 = 1;

    Set<Character> set = new LinkedHashSet<>();

    int max = Integer.MIN_VALUE;

    while (p1 != p2) {
      max = Math.max(max, set.size());

      set.add(chars[p1]);

      if (p2 > len - 1) {
        break;
      }

      if (!set.contains(chars[p2])) {
        set.add(chars[p2]);
        p2++;
        continue;
      }

      p1++;
      p2 = p1 + 1;

      set.clear();
    }

    return Math.max(max, set.size());
  }
}
