package hackerrank.kits;

import java.util.*;

public class LonelyInteger {
  public static int lonelyinteger(List<Integer> a) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer key : a) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    for (int key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(lonelyinteger(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
  }
}
