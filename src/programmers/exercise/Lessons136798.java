package programmers.exercise;

import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
public class Lessons136798 {
  public static void main(String[] args) {
    System.out.println(new Lessons136798().solution(5, 3, 2));
    System.out.println(new Lessons136798().solution(10, 3, 2));
  }

  public int solution(int number, int limit, int power) {
    return IntStream.rangeClosed(1, number)
            .map(n -> (int) IntStream.rangeClosed(1, (int) Math.sqrt(n))
                    .filter(i -> n % i == 0)
                    .flatMap(i -> {
                      if (i != n / i) {
                        return IntStream.of(n, n / i);
                      }
                      return IntStream.of(i);
                    })
                    .count()
            )
            .map(count -> {
              if (count > limit) {
                return power;
              }
              return count;
            })
            .sum();
  }
}
