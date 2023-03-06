package programmers.exercise;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class Lessons140108 {
  public static void main(String[] args) {
    System.out.println(new Lessons140108().solution("banana"));
    System.out.println(new Lessons140108().solution("abracadabra"));
    System.out.println(new Lessons140108().solution("aaabbaccccabba"));
  }

  public int solution(String s) {
    final var chars = s.toCharArray();

    var sameCount = 0;
    var diffCount = 0;
    var start = s.charAt(0);
    var count = 0;

    for (int i = 0; i < chars.length; i++) {
      if (start == chars[i]) {
        sameCount++;
      } else {
        diffCount++;
      }
      if (sameCount == diffCount) {
        sameCount = 0;
        diffCount = 0;
        count++;
        start = chars[Math.min(i + 1, chars.length - 1)];
      } else if (i == chars.length - 1) {
        count++;
      }
    }

    return count;
  }
}
