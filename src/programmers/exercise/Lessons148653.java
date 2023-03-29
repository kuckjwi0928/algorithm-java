package programmers.exercise;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class Lessons148653 {
  public static void main(String[] args) {
    System.out.println(new Lessons148653().solution(16));
    System.out.println(new Lessons148653().solution(2554));
  }

  public int solution(int storey) {
    var answer = 0;
    while (storey != 0) {
      final var digit = storey % 10;
      if (digit > 5) {
        answer += 10 - digit;
        storey += 10;
      } else if (digit < 5) {
        answer += digit;
      } else {
        if ((storey / 10) % 10 >= 5) {
          storey += 10;
        }
        answer += digit;
      }
      storey /= 10;
    }
    return answer;
  }
}
