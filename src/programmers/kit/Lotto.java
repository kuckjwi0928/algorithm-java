package programmers.kit;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lotto().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    System.out.println(Arrays.toString(new Lotto().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
    System.out.println(Arrays.toString(new Lotto().solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
  }
  public int[] solution(int[] lottos, int[] win_nums) {
    Map<Integer, Integer> ranking = Map.of(
            6, 1,
            5, 2,
            4, 3,
            3, 4,
            2, 5,
            1, 6,
            0, 6
    );
    Set<Integer> set = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());

    int matchCount = 0;
    int zeroCount = 0;

    for (int lotto : lottos) {
      if (set.contains(lotto)) {
        matchCount++;
      } else if (lotto == 0) {
        zeroCount++;
      }
    }

    return new int[]{ranking.get(matchCount + zeroCount), ranking.get(matchCount)};
  }
}
