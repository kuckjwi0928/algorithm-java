package programmers.kit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MockTest {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new MockTest().solution(new int[]{1, 2, 3, 4, 5})));
    System.out.println(Arrays.toString(new MockTest().solution(new int[]{1, 3, 2, 4, 2})));
  }

  public int[] solution(int[] answers) {
    int[] m1 = new int[]{1,2,3,4,5};
    int[] m2 = new int[]{2,1,2,3,2,4,2,5};
    int[] m3 = new int[]{3,3,1,1,2,2,4,4,5,5};

    Map<Integer, Integer> map = new TreeMap<>();

    for (int i = 0; i < answers.length; i++) {
      if (m1[i % m1.length] == answers[i]) {
        map.compute(1, (k, v) -> {
          if (v == null) {
            return 1;
          }
          return v + 1;
        });
      }
      if (m2[i % m2.length] == answers[i]) {
        map.compute(2, (k, v) -> {
          if (v == null) {
            return 1;
          }
          return v + 1;
        });
      }
      if (m3[i % m3.length] == answers[i]) {
        map.compute(3, (k, v) -> {
          if (v == null) {
            return 1;
          }
          return v + 1;
        });
      }
    }

    int max = Collections.max(map.values());

    return map.entrySet()
      .stream()
      .filter(e -> e.getValue() >= max)
      .mapToInt(Map.Entry::getKey)
      .toArray();
  }
}
