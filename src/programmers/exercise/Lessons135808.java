package programmers.exercise;

import java.util.Arrays;

public class Lessons135808 {
  public static void main(String[] args) {
    System.out.println(new Lessons135808().solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    System.out.println(new Lessons135808().solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
  }

  public int solution(int k, int m, int[] score) {
    Arrays.sort(score);

    var sum = 0;

    for (int i = score.length - 1; i >= m - 1; i = i - m) {
      final var min = score[i - m + 1];
      sum += min * m;
    }

    return sum;
  }
}
