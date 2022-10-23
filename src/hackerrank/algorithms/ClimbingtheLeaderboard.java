package hackerrank.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingtheLeaderboard {
  public static void main(String[] args) {
    ClimbingtheLeaderboard.climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10), List.of(5, 25, 50, 120));
    ClimbingtheLeaderboard.climbingLeaderboard(List.of(100, 90, 90, 80), List.of(70, 80, 105));
  }


  // [100, 50, 40, 20, 10]
  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    ranked = ranked.stream().distinct().collect(Collectors.toList());

    List<Integer> result = new ArrayList<>();

    int i = ranked.size() - 1;

    for (int playerScore : player) {
      while (i != 0 && playerScore >= ranked.get(i)) {
        i--;
      }
      if (playerScore < ranked.get(i)) {
        result.add(i + 2);
      } else {
        result.add(i + 1);
      }
    }

    return result;
  }
}
