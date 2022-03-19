package programmers.kit;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
  public static void main(String[] args) {
    String[][] clothes = new String[][]{
      {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
    };
    System.out.println(new Camouflage().solution(clothes));
  }

  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();

    for (String[] cloth : clothes) {
      map.compute(cloth[1], (k, v) -> {
        if (v == null) {
          return 1;
        }
        v++;
        return v;
      });
    }

    return map.values().stream().reduce(1, (a, c) -> a * (c + 1)) - 1;
  }
}
