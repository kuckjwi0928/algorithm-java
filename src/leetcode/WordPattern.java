package leetcode;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern {
  public static void main(String[] args) {
    System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
  }

  public boolean wordPattern(String pattern, String s) {
    var words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }
    var stringHashMap = new HashMap<Character, String>();
    var charHashMap = new HashMap<String, Character>();
    for (var i = 0; i < pattern.length(); i++) {
      var c = pattern.charAt(i);
      var word = words[i];
      if (!stringHashMap.containsKey(c) && !charHashMap.containsKey(word)) {
        stringHashMap.put(c, word);
        charHashMap.put(word, c);
      } else if (!Objects.equals(stringHashMap.get(c), word)) {
        return false;
      }
    }
    return true;
  }
}
