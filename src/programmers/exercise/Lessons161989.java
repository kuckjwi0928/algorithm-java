package programmers.exercise;

public class Lessons161989 {
  public static void main(String[] args) {
    System.out.println(new Lessons161989().solution(8, 4, new int[]{2,3,6}));
  }

  public int solution(int n, int m, int[] section) {
    var count = 0;
    var limit = Integer.MIN_VALUE;
    for (int s : section) {
      if (s < limit) {
        continue;
      }
      count++;
      limit = m + s;
    }
    return count;
  }
}
