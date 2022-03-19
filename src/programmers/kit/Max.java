package programmers.kit;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Max {
  public static void main(String[] args) {
    System.out.println(new Max().solution(new int[]{6, 10, 2}));
  }

  public String solution(int[] numbers) {
    String answer = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
            .collect(Collectors.joining());
    return answer.charAt(0) == '0' ? "0" : answer;
  }
}
