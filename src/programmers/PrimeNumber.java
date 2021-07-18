package programmers;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {
  public static void main(String[] args) {
    System.out.println(new PrimeNumber().solution("123"));
  }

  public int solution(String numbers) {
    Set<Integer> set = new HashSet<>();
    char[] chars = numbers.toCharArray();
    boolean[] visited = new boolean[chars.length];

    dfs("", set, chars, visited);

    return (int) set.stream()
      .filter(this::isPrimeNumber)
      .count();
  }

  private void dfs(String temp, Set<Integer> set, char[] chars, boolean[] visited) {
    if (temp.length() > 0) {
      set.add(Integer.parseInt(temp));
    }
    for (int i = 0; i < chars.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(temp + chars[i], set, chars, visited);
        visited[i] = false;
      }
    }
  }

  private boolean isPrimeNumber(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
