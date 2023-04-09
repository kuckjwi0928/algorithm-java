package programmers.exercise;

import java.util.Arrays;

public class Lessons178870 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons178870().solution(new int[]{1, 2, 3, 4, 5}, 7)));
    System.out.println(Arrays.toString(new Lessons178870().solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
    System.out.println(Arrays.toString(new Lessons178870().solution(new int[]{2, 2, 2, 2, 2}, 6)));
  }

  public int[] solution(int[] sequence, int k) {
    var left = 0;
    var right = 0;
    var sum = sequence[left];
    var length = sequence.length;
    var min = Integer.MAX_VALUE;
    var start = Integer.MAX_VALUE;
    var end = Integer.MAX_VALUE;

    while (left < length && right < length) {
      if (sum < k) {
        right++;
        if (right < length) {
          sum += sequence[right];
        }
      } else if (sum > k) {
        sum -= sequence[left];
        left++;
      } else {
        if (min > right - left) {
          min = right - left;
          start = left;
          end = right;
        }
        right++;
        if (right < length) {
          sum += sequence[right];
        }
      }
    }

    return new int[]{start, end};
  }
}
