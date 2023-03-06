package programmers.exercise;


public class Lessons155652 {
  public static void main(String[] args) {
    System.out.println(new Lessons155652().solution("aukks", "wbqd", 5));
  }

  public String solution(String s, String skip, int index) {
    final var builder = new StringBuilder(s);
    for (int i = 0; i < builder.length(); i++) {
      var c = builder.charAt(i);
      for (int j = 0; j < index; j++) {
        c++;
        if (c > 'z') {
          c = 'a';
        }
        if (skip.indexOf(c) != -1) {
          j--;
        }
      }
      builder.setCharAt(i, c);
    }
    return builder.toString();
  }
}
