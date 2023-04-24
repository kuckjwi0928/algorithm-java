package programmers.exercise;

import java.util.Arrays;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class Lessons176963 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons176963().solution(
            new String[]{"may", "kein", "kain", "radi"},
            new int[]{5, 10, 1, 3},
            new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}))
    );
  }

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    final var map = new HashMap<String, Integer>();
    for (var i = 0; i < name.length; i++) {
      map.put(name[i], yearning[i]);
    }
    return Arrays.stream(photo)
            .mapToInt(arr -> Arrays.stream(arr)
                    .mapToInt(a -> map.getOrDefault(a, 0))
                    .sum()
            )
            .toArray();
  }
}
