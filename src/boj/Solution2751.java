package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2751 {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      List<Integer> list = new ArrayList<>();
      int N = Integer.parseInt(reader.readLine());
      for (int i = 0; i < N; i++) {
        list.add(Integer.parseInt(reader.readLine()));
      }
      System.out.println(
        list.stream()
          .sorted(Integer::compare)
          .map(String::valueOf)
          .collect(Collectors.joining(System.lineSeparator()))
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
