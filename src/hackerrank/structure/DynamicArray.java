package hackerrank.structure;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
  public static void main(String[] args) {
    System.out.println(dynamicArray(2, List.of(
      List.of(1, 0, 5),
      List.of(1, 1, 7),
      List.of(1, 0, 3),
      List.of(2, 1, 0),
      List.of(2, 1, 1)
    )));
  }

  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    int lastAnswer = 0;

    List<List<Integer>> seqs = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    for( int i = 0; i < n; i++) {
      seqs.add(new ArrayList<>());
    }

    for (List<Integer> query : queries) {
      int type = query.get(0);
      int x = query.get(1);
      int y = query.get(2);

      int idx = (x ^ lastAnswer) % n;

      int size = seqs.get(idx).size();

      if (type == 1) {
        seqs.get(idx).add(y);
      } else {
        lastAnswer = seqs.get(idx).get(y % size);
        result.add(lastAnswer);
      }
    }
    return result;
  }
}
