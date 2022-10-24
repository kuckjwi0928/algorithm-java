package leetcode;

import java.util.List;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
  public static void main(String[] args) {
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("un", "iq", "ue")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("char", "r", "act", "ers")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("cha", "r", "act", "ers")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("aa", "bb")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("jnfbyktlrqumowxd","mvhgcpxnjzrdei")));
    System.out.println(new MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength(List.of("a", "abc", "d", "de", "def")));
  }

  public int maxLength(List<String> arr) {
    return solution(arr, 0, "");
  }

  public int solution(List<String> arr, int start, String s) {
    if (start == arr.size()) {
      return isUnique(s) ? s.length() : 0;
    }
    int max = 0;
    max = Math.max(max, solution(arr, start + 1, s));
    max = Math.max(max, solution(arr, start + 1, s + arr.get(start)));
    return max;
  }

  public boolean isUnique(String s) {
    int[] arr = new int[26];
    char[] chars = s.toCharArray();

    for (char c : chars) {
      int index = c - 'a';
      arr[index]++;
      if (arr[index] > 1) {
        return false;
      }
    }

    return true;
  }
}
