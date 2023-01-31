package leetcode;

import java.util.HashMap;
import java.util.Objects;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
  public static void main(String[] args) {
    System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
    System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
    System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
  }

  public boolean isIsomorphic(String s, String t) {
    final var chars1 = s.toCharArray();
    final var chars2 = t.toCharArray();
    final var mapS = new HashMap<Character, Integer>();
    final var mapT = new HashMap<Character, Integer>();
    for (int i = 0 ; i < chars1.length; i++) {
      if (!Objects.equals(mapS.get(chars1[i]), mapT.get(chars2[i]))) {
        return false;
      }
      mapS.put(chars1[i], i);
      mapT.put(chars2[i], i);
    }
    return true;
  }
}
