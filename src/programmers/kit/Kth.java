package programmers.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kth {
  public static void main(String[] args) {
    new Kth().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
  }

  public int[] solution(int[] array, int[][] commands) {
    List<Integer> answer = new ArrayList<>();

    for (int[] command : commands) {
      answer.add(Arrays.stream(array)
        .skip(command[0] - 1)
        .limit(command[1] - command[0] + 1)
        .sorted()
        .boxed()
        .collect(Collectors.toList())
        .get(command[2] - 1)
      );
    }

    return answer.stream().mapToInt(i -> i).toArray();
  }
}
