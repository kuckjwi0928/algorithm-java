package programmers.exercise;

// https://school.programmers.co.kr/learn/courses/30/lessons/147355
public class Lessons147355 {
  public static void main(String[] args) {
    System.out.println(new Lessons147355().solution("3141592", "271"));
    System.out.println(new Lessons147355().solution("500220839878", "7"));
    System.out.println(new Lessons147355().solution("10203", "15"));
  }

  public int solution(String t, String p) {
    final var tLen = t.length();
    final var pLen = p.length();
    var count = 0;
    for (int i = 0; i <= tLen - pLen; i++) {
      if (t.substring(i, i + pLen).compareTo(p) < 1) {
        count++;
      }
    }
    return count;
  }
}
