package programmers.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class Lessons131701 {
  public static void main(String[] args) {
    System.out.println(new Lessons131701().solution(new int[]{7, 9, 1, 1, 4}));
  }

  public int solution(int[] elements) {
    var list = Arrays.stream(elements)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
    var set = new HashSet<>();
    for (var i = 1; i <= elements.length; i++) {
      list.add(list.get(i - 1));
      for (var j = 0; j < elements.length; j++) {
        set.add(list.subList(j, j + i).stream().reduce(0, Integer::sum));
      }
    }
    return set.size();
  }
}
