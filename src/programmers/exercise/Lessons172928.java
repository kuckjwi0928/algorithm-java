package programmers.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lessons172928 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons172928().solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
    System.out.println(Arrays.toString(new Lessons172928().solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
    System.out.println(Arrays.toString(new Lessons172928().solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
  }

  public int[] solution(String[] park, String[] routes) {
    var x = 0;
    var y = 0;

    for (var i = 0; i < park.length; i++) {
      for (var j = 0; j < park[0].length(); j++) {
        if (park[i].charAt(j) == 'S') {
          x = j;
          y = i;
          break;
        }
      }
    }

    final var mapping = Map.ofEntries(
            Map.entry("E", List.of(1, 0)),
            Map.entry("W", List.of(-1, 0)),
            Map.entry("S", List.of(0, 1)),
            Map.entry("N", List.of(0, -1))
    );

    routeLoop: for (var s : routes) {
      var route = s.split(" ");
      var direction = mapping.get(route[0]);
      var position = Integer.parseInt(route[1]);
      var nx = x;
      var ny = y;
      for (var i = 0; i < position; i++) {
        nx += direction.get(0);
        ny += direction.get(1);
        if (nx < 0 || nx >= park[0].length() || ny < 0 || ny >= park.length || 'X' == park[ny].charAt(nx)) {
          continue routeLoop;
        }
      }
      x = nx;
      y = ny;
    }
    return new int[]{y, x};
  }
}
