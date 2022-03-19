package programmers.kit;

import java.util.Arrays;
import java.util.Collections;

public class SkillCheck1 {
  public static void main(String[] args) {
    new SkillCheck1().solution("Zbcdefg");
  }

  public String solution(String s) {
    char[] arr = s.toCharArray();
    Integer[] scores = new Integer[arr.length];

    for (int i = 0; i < arr.length; i++) {
      scores[i] = (int) arr[i];
    }

    Arrays.sort(scores, Collections.reverseOrder());

    StringBuilder builder = new StringBuilder();

    for (Integer score : scores) {
      builder.append((char) score.intValue());
    }

    return builder.toString();
  }
}
