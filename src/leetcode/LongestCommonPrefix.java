package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"cir", "car"}));
  }

  public String longestCommonPrefix(String[] strs) {
    StringBuilder prefix = new StringBuilder();

    int limit = Arrays.stream(strs).map(String::length).min(Integer::compare).get();
    
    char[] firsts = strs[0].toCharArray();

    for (int i = 0; i < limit; i++) {
      for (int j = 1; j < strs.length; j++) {
        if (firsts[i] != strs[j].codePointAt(i)) {
          return prefix.toString();
        }
      }
      prefix.append(firsts[i]);
    }

    return prefix.toString();
  }
}
