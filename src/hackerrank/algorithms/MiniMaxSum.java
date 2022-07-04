package hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
    Result.miniMaxSum(arr);
    bufferedReader.close();
  }

  static class Result {
    public static void miniMaxSum(List<Integer> arr) {
      arr.sort(Integer::compareTo);
      int size = arr.size();
      long min = 0, max = 0;
      for (int i = 0; i < size - 1; i++) {
        min += arr.get(i);
      }
      for (int i = 1; i < size; i++) {
        max += arr.get(i);
      }
      System.out.println(min + " " + max);
    }
  }
}
