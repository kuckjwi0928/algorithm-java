package hackerrank.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
public class BirthdayCakeCandles {
  public static void main(String[] args) {
    System.out.println(birthdayCakeCandles(Arrays.asList(4, 4, 1, 3)));
    System.out.println(birthdayCakeCandles(Arrays.asList(3, 2, 1, 3)));
  }

  public static int birthdayCakeCandles(List<Integer> candles) {
    candles.sort(Comparator.reverseOrder());
    int max = candles.get(0);
    int count = 1;
    for (int i = 1; i < candles.size(); i++) {
      if (candles.get(i) < max) {
        break;
      }
      count++;
    }
    return count;
  }
}
