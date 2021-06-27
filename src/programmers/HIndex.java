package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {
  public static void main(String[] args) {
    System.out.println(new HIndex().solution(new int[]{3, 0, 6, 1, 5}));
  }

  public int solution(int[] citations) {
    int answer = 0;

    List<Integer> list = Arrays.stream(citations)
            .boxed()
            .sorted()
            .collect(Collectors.toList());

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) <= i + 1) {
        answer++;
      }
    }

    return answer;
  }
}
