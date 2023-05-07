package programmers.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
public class Lessons132265 {
  public static void main(String[] args) {
    System.out.println(new Lessons132265().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    System.out.println(new Lessons132265().solution(new int[]{1, 2, 3, 1, 4}));
  }

  public int solution(int[] topping) {
    var map = Arrays.stream(topping)
            .boxed()
            .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
    var set = new HashSet<>();
    var answer = 0;
    for (var t : topping) {
      var l = map.get(t);
      if (l - 1 == 0) {
        map.remove(t);
      } else {
        map.put(t, l - 1);
      }
      set.add(t);
      if (map.size() == set.size()) {
        answer++;
      }
    }
    return answer;
  }
}
