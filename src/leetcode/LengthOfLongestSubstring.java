package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    char[] chars = s.toCharArray();

    int num = 0;
    int max = 0;

    for (int i = 0; i < chars.length; i++){
      if (map.containsKey(chars[i])) {
        num = Math.max(num, map.get(chars[i]) + 1);
      }
      map.put(chars[i], i);
      max = Math.max(max, i - num + 1);
    }

    return max;
  }
}
