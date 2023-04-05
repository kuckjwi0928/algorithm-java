package programmers.exercise;

public class Lessons140107 {
  public static void main(String[] args) {
    System.out.println(new Lessons140107().solution(2, 4));
  }

  public long solution(int k, int d) {
    long answer = 0;
    for (var i = 0; i <= d; i += k) {
      answer += (int) (Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(i, 2)) / k + 1);
    }
    return answer;
  }
}
