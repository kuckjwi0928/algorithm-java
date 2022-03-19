package programmers.kit;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class N {
  public static void main(String[] args) {
    System.out.println(new N().solution(5, 12));
    System.out.println(new N().solution(2, 11));
  }

  public int solution(int N, int number) {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    int n = 0;

    for (int i = 0; i < 8; i++) {
      Set<Integer> set = new LinkedHashSet<>();
      n = i != 0 ? n * 10 + N : N;
      set.add(n);
      map.put(i, set);
    }

    for (int i = 0; i < 8; i++) {
      Set<Integer> set = new LinkedHashSet<>(map.get(i));
      for (int j = 0; j < i; j++) {
        for (Integer num1 : map.get(j)) {
          for (Integer num2 : map.get(i - j - 1)) {
            set.add(num1 + num2);
            set.add(num1 - num2);
            set.add(num1 * num2);

            if (num2 != 0) {
              set.add(num1 / num2);
            }
          }
        }
      }

      if (set.contains(number)) {
        return i + 1;
      }

      map.put(i, set);
    }

    return -1;
  }
}
