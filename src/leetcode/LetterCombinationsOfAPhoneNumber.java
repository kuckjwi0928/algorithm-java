package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
  private final static Map<Character, List<Character>> MAPPING = new HashMap<>();

  static {
    MAPPING.put('2', List.of('a', 'b', 'c'));
    MAPPING.put('3', List.of('d', 'e', 'f'));
    MAPPING.put('4', List.of('g', 'h', 'i'));
    MAPPING.put('5', List.of('j', 'k', 'l'));
    MAPPING.put('6', List.of('m', 'n', 'o'));
    MAPPING.put('7', List.of('p', 'q', 'r', 's'));
    MAPPING.put('8', List.of('t', 'u', 'v'));
    MAPPING.put('9', List.of('w', 'x', 'y', 'z'));
  }

  public static void main(String[] args) {
    System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("2"));
    System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("234"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return Collections.emptyList();
    }

    if (digits.length() == 1) {
      return MAPPING.get(digits.charAt(0)).stream().map(String::valueOf).collect(Collectors.toList());
    }

    List<String> results = new LinkedList<>();
    combine(digits, 0, "", results);
    return results;
  }

  private void combine(String digits, int start, String s, List<String> results) {
    int limit = digits.length();

    if (start > limit) {
      return;
    }

    if (s.length() == limit) {
      results.add(s);
      return;
    }

    for (Character c : MAPPING.get(digits.charAt(start))) {
      combine(digits, start + 1, s + c, results);
    }
  }
}
