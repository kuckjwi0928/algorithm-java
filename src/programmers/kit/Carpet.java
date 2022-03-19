package programmers.kit;

import java.util.Arrays;

public class Carpet {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Carpet().solution(10, 2)));
    System.out.println(Arrays.toString(new Carpet().solution(8, 1)));
    System.out.println(Arrays.toString(new Carpet().solution(24, 24)));
  }

  public int[] solution(int brown, int yellow) {
    int total = brown + yellow;

    for (int i = total / 2; i > 0; i --) {
      int height = total / i;

      if ((i - 2) * (height - 2) == yellow) {
        return new int[]{i, height};
      }
    }

    return null;
  }
}
