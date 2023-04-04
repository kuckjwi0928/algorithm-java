package programmers.exercise;

public class Lessons132267 {
  public static void main(String[] args) {
    System.out.println(new Lessons132267().solution(2, 1, 20));
    System.out.println(new Lessons132267().solution(3, 1, 20));
  }
  public int solution(int a, int b, int n) {
    var answer = 0;
    while (n >= a) {
      var take = n - n % a;
      var get = (take / a) * b;
      answer += get;
      n = get + n - take;
    }
    return answer;
  }
}
