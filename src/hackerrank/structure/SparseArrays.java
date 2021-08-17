package hackerrank.structure;

import java.util.LinkedList;
import java.util.List;

public class SparseArrays {
  public static void main(String[] args) {
    System.out.println(matchingStrings(List.of("ab", "ab", "abc"), List.of("ab", "abc", "bc")));
    System.out.println(matchingStrings(List.of("aba", "baba", "aba", "xzxb"), List.of("aba", "xzxb", "ab")));
    System.out.println(matchingStrings(List.of("def", "de", "fgh"), List.of("de", "lmn", "fgh")));
    System.out.println(matchingStrings(
      List.of("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
      List.of("abcde", "sdaklfj", "asdjf", "na", "basdn")
    ));
  }

  public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    List<Integer> results = new LinkedList<>();

    for (String query : queries) {
      int count = 0;
      for (String s : strings) {
        if (query.equals(s)) {
          count++;
        }
      }
      results.add(count);
    }

    return results;
  }
}
