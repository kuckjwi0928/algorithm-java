package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAlbum {
  public static void main(String[] args) {
    String[] genres = new String[] {
      "classic", "pop", "classic", "classic", "pop"
    };
    int[] plays = new int[] {
      500, 600, 150, 800, 2500
    };
    new BestAlbum().solution(genres, plays);
  }

  public int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> totalMap = new HashMap<>();
    Map<String, Map<Integer, Integer>> infoMap = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
      Map<Integer, Integer> map = infoMap.getOrDefault(genres[i], new HashMap<>());
      map.put(i, plays[i]);
      infoMap.put(genres[i], map);
    }

    List<Map.Entry<String, Integer>> totalList = new ArrayList<>(totalMap.entrySet());

    totalList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    List<Integer> results = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : totalList) {
      List<Map.Entry<Integer, Integer>> list = new ArrayList<>(infoMap.get(entry.getKey()).entrySet());
      list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
      results.addAll(list.stream().limit(2).map(Map.Entry::getKey).collect(Collectors.toList()));
    }

    return results.stream().mapToInt(i -> i).toArray();
  }
}
