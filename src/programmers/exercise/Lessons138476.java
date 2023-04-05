package programmers.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lessons138476 {
  public static void main(String[] args) {
    System.out.println(new Lessons138476().solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(new Lessons138476().solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(new Lessons138476().solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
  }

  public int solution(int k, int[] tangerine) {
    final var list = Arrays.stream(tangerine)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values()
            .stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    var answer = 0;
    var sum = 0;
    for (var i : list) {
      if (sum >= k) {
        break;
      }
      sum += i;
      answer++;
    }
    return answer;
  }
}
