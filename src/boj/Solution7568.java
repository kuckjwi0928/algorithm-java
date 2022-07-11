package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/7568
public class Solution7568 {
  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(reader.readLine());
      for (int i = 0; i < N; i++) {
        String line = reader.readLine();
        String[] inputs = line.split(" ");
        int w = Integer.parseInt(inputs[0]);
        int h = Integer.parseInt(inputs[1]);
        list.add(List.of(w, h));
      }

      List<Integer> results = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
        int w = list.get(i).get(0);
        int h = list.get(i).get(1);
        int rank = 1;
        for (int j = 0; j < list.size(); j++) {
          if (i == j) {
            continue;
          }
          if (w < list.get(j).get(0) && h < list.get(j).get(1)) {
            rank++;
          }
        }
        results.add(rank);
      }

      System.out.println(results.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
