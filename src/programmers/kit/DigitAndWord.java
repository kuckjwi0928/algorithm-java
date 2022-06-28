package programmers.kit;

import java.util.Map;

public class DigitAndWord {
  public static void main(String[] args) {
    System.out.println(new DigitAndWord().solution("23four5six7"));
    System.out.println(new DigitAndWord().solution("2three45sixseven"));
    System.out.println(new DigitAndWord().solution("123"));
  }

  public int solution(String s) {
    Map<String, Integer> mapping = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );
    StringBuilder builder = new StringBuilder();
    StringBuilder letter = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        builder.append(c);
        continue;
      }
      letter.append(c);
      if (mapping.containsKey(letter.toString())) {
        builder.append(mapping.get(letter.toString()));
        letter.setLength(0);
      }
    }

    return Integer.parseInt(builder.toString());
  }
}
