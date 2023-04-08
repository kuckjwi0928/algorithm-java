package programmers.exercise;

public class Lessons131705 {
  public static void main(String[] args) {
    System.out.println(new Lessons131705().solution(new int[]{-2, 3, 0, 2, -5}));
    System.out.println(new Lessons131705().solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
    System.out.println(new Lessons131705().solution(new int[]{-1, 1, -1, 1}));
  }

  public int solution(int[] number) {
    var count = 0;
    for (int i = 0; i < number.length; i++) {
      for (int j = i + 1; j < number.length; j++) {
        for (int k = j + 1; k < number.length; k++) {
          if (number[i] + number[j] + number[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
