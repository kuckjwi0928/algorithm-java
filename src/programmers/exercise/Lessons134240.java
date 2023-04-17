package programmers.exercise;

public class Lessons134240 {
  public static void main(String[] args) {
    System.out.println(new Lessons134240().solution(new int[]{1, 3, 4, 6}));
    System.out.println(new Lessons134240().solution(new int[]{1, 7, 1, 2}));
  }

  public String solution(int[] food) {
    var builder = new StringBuilder();
    for (var i = 1; i < food.length; i++) {
      builder.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
    }
    return builder + "0" + new StringBuilder(builder).reverse();
  }
}
