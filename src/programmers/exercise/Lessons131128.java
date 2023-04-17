package programmers.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Lessons131128 {
  public static void main(String[] args) {
    System.out.println(new Lessons131128().solution("0000", "0000"));
    System.out.println(new Lessons131128().solution("100", "2345"));
    System.out.println(new Lessons131128().solution("100", "203045"));
    System.out.println(new Lessons131128().solution("100", "123450"));
    System.out.println(new Lessons131128().solution("12321", "42531"));
    System.out.println(new Lessons131128().solution("5325", "1255"));
  }

  public String solution(String X, String Y) {
    var map1 = new HashMap<Integer, Integer>();
    var map2 = new HashMap<Integer, Integer>();

    for (var c : X.toCharArray()) {
      var n = Character.getNumericValue(c);
      map1.put(n, map1.getOrDefault(n, 0) + 1);
    }

    for (var c : Y.toCharArray()) {
      var n = Character.getNumericValue(c);
      map2.put(n, map2.getOrDefault(n, 0) + 1);
    }

    var list = new ArrayList<Integer>();

    for (var i = 0; i < 10; i++) {
      var a = map1.getOrDefault(i, 0);
      var b = map2.getOrDefault(i, 0);
      for (var j = 0; j < Math.min(a, b); j++) {
        list.add(i);
      }
    }

    if (list.isEmpty()) {
      return "-1";
    }

    list.sort(Comparator.reverseOrder());

    if (list.get(0) == 0) {
      return "0";
    }

    return list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
  }
}
