package programmers.kit;

public class Joystick {
  public static void main(String[] args) {
    new Joystick().solution("JAZ"); // 11
    new Joystick().solution("JEROEN"); // 56
    new Joystick().solution("JAN"); // 23
    new Joystick().solution("AABAAAAAAABBB"); // 11
    new Joystick().solution("CANAAAAANAN"); // 48
  }

  public int solution(String name) {
    char[] chars = name.toCharArray();

    int answer = 0;
    int min = name.length() - 1;

    for (int i = 0; i < chars.length; i++) {
      answer += Math.min((int) chars[i] - 'A', (int) 'Z' - chars[i] + 1);

      int j = i + 1;

      while (j < chars.length && chars[j] == 'A') {
        j++;
      }


      min = Math.min(min, i + i + chars.length - j);
    }

    answer += min;

    return answer;
  }
}
