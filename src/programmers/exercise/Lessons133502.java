package programmers.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lessons133502 {
  public static void main(String[] args) {
    System.out.println(new Lessons133502().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    System.out.println(new Lessons133502().solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    System.out.println(new Lessons133502().solution(new int[]{1,2,3,1}));
    System.out.println(new Lessons133502().solution(new int[]{1,2,3,1,1,2,3,1}));
    System.out.println(new Lessons133502().solution(new int[]{1,2}));
    System.out.println(new Lessons133502().solution(new int[]{1}));
    System.out.println(new Lessons133502().solution(new int[]{1,1,1,1,1,2,3,1}));
    System.out.println(new Lessons133502().solution(new int[]{1,1,2,3,1,1,2,3,1}));
    System.out.println(new Lessons133502().solution(new int[]{2,2,3,1}));
    System.out.println(new Lessons133502().solution(new int[]{1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1}));
  }

  public int solution(int[] ingredient) {
    final var hambuger = List.of(1, 2, 3, 1);
    var list = Arrays.stream(ingredient)
            .boxed()
            .collect(Collectors.toList());
    var count = 0;
    var i = 0;
    while (i < list.size() - 3) {
      if (Objects.equals(list.subList(i, i + 4), hambuger)) {
        list.subList(i, i + 4).clear();
        i = Math.max(0, i - 3);
        count++;
        continue;
      }
      i++;
    }
    return count;
  }
}
