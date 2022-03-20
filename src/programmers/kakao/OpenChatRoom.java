package programmers.kakao;

import java.util.*;
import java.util.stream.Collectors;

public class OpenChatRoom {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new OpenChatRoom().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
  }

  public String[] solution(String[] records) {
    Map<String, String> map = new HashMap<>();
    List<String> messages = new ArrayList<>();

    for (String record : records) {
      String[] split = record.split(" ");
      switch (split[0]) {
        case "Enter":
          messages.add(String.format("%s 님이 들어왔습니다.", split[1]));
          map.put(split[1], split[2]);
          break;
        case "Change":
          map.put(split[1], split[2]);
          break;
        case "Leave":
          messages.add(String.format("%s 님이 나갔습니다.", split[1]));
          break;
        default:
          break;
      }
    }
    return messages.stream().map(message -> {
      String[] split = message.split(" ");
      return String.join(" ", map.get(split[0]) + split[1], split[2]);
    }).collect(Collectors.toList()).toArray(new String[]{});
  }
}
