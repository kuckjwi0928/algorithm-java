package programmers.exercise;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=python3
public class Lessons12911 {
  public static void main(String[] args) {
    System.out.println(new Lessons12911().solution(78));
    System.out.println(new Lessons12911().solution(15));
  }

  public int solution(int n) {
    var answer = n;
    var count = Integer.bitCount(n);
    while (true) {
      answer++;
      if (count == Integer.bitCount(answer)) {
        return answer;
      }
    }
  }
}
