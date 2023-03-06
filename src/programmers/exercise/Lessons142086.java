package programmers.exercise;

import java.util.Arrays;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Lessons142086 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons142086().solution("banana")));
    System.out.println(Arrays.toString(new Lessons142086().solution("foobar")));
  }

  public int[] solution(String s) {
    final var map = new HashMap<Character, Integer>();
    final var chars = s.toCharArray();
    final var results = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      var idx = map.getOrDefault(chars[i], -1);
      results[i] = idx == -1 ? idx : i - idx;
      map.put(chars[i], i);
    }
    return results;
  }
}
