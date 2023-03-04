package programmers.exercise;

import java.util.Arrays;
import java.util.HashMap;

public class Lessons160586 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons160586().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"})));
    System.out.println(Arrays.toString(new Lessons160586().solution(new String[]{"AA"}, new String[]{"B"})));
    System.out.println(Arrays.toString(new Lessons160586().solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})));
  }

  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];

    var keyMap = new HashMap<Character, Integer>();

    for (final var key : keymap) {
      char[] chars = key.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        final var defaultValue = i + 1;
        keyMap.put(chars[i], Math.min(defaultValue, keyMap.getOrDefault(chars[i], defaultValue)));
      }
    }

    var answerIndex = 0;

    for (final var target : targets) {
      var sum = 0;
      char[] chars = target.toCharArray();
      var unsuccessful = false;
      for (char aChar : chars) {
        if (!keyMap.containsKey(aChar)) {
          unsuccessful = true;
          break;
        }
        sum += keyMap.get(aChar);
      }
      answer[answerIndex++] = unsuccessful ? -1 : sum;
    }

    return answer;
  }
}
