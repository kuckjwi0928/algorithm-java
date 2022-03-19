package programmers.kit;

import java.util.Arrays;

public class Lifeboat {
  public static void main(String[] args) {
    System.out.println(new Lifeboat().solution(new int[]{70, 50, 80, 50}, 100));
    System.out.println(new Lifeboat().solution(new int[]{70, 80, 50}, 100));
  }

  public int solution(int[] people, int limit) {
    Arrays.sort(people);

    int p1 = 0;
    int p2 = people.length - 1;

    int count = 0;

    while (p1 <= p2) {
      int sum = people[p1] + people[p2];
      if (sum <= limit) {
        p1++;
      }
      p2--;
      count++;
    }

    return count;
  }
}
