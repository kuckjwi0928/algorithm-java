package programmers.kit;

import java.util.*;
import java.util.stream.Collectors;

public class Tuple {
  public static void main(String[] args) {
    new Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"	);
    new Tuple().solution("{{123}}"	);
    new Tuple().solution("{{20,111},{111}}");
    new Tuple().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
  }

  public int[] solution(String s) {
    String[] inputs = s.substring(2, s.length() - 2).split("},\\{");
    List<String> list = Arrays.stream(inputs).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    Set<Integer> set = new LinkedHashSet<>();
    for (String l : list) {
      for (String numStr : l.split(",")) {
        set.add(Integer.parseInt(numStr));
      }
    }
    return set.stream().mapToInt(m -> m).toArray();
  }
}
