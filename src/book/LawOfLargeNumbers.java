package book;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LawOfLargeNumbers {
  public static void main(String[] args) {
    System.out.println(solution(8, 3, new int[]{2,4,5,4,6}));
    System.out.println(solution(7, 2, new int[]{3,4,3,4,3}));
  }

  private static int solution(int M, int K, int[] numbers) {
    List<Integer> list = Arrays.stream(numbers).boxed()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

    int first = list.get(0);
    int second = list.get(1);

    int count = M / (K + 1) * K + (M % (K + 1));

    return (count * first) + (M - count) * second;
  }
}
