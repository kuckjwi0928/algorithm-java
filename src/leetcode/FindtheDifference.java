package leetcode;

// https://leetcode.com/problems/find-the-difference/
public class FindtheDifference {
  public static void main(String[] args) {
    var obj = new FindtheDifference();
    System.out.println(obj.findTheDifference("abcd", "abcde"));
    System.out.println(obj.findTheDifference("a", "aa"));
    System.out.println(obj.findTheDifference("ae", "aea"));
    System.out.println(obj.findTheDifference("", "y"));
  }

  public char findTheDifference(String s, String t) {
    var counter = new int[26];
    for (final var c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    for (final var c : t.toCharArray()) {
      if (counter[c - 'a'] == 0) {
        return c;
      } else {
        counter[c - 'a']--;
      }
    }
    return 'a';
  }
}
