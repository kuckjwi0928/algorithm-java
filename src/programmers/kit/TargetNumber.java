package programmers.kit;

public class TargetNumber {
  public static void main(String[] args) {
    System.out.println(new TargetNumber().solution(new int[]{4,1,2,1}, 4));
  }

  public int solution(int[] numbers, int target) {
    return dfs(numbers, target, 0);
  }

  private int dfs(int[] numbers, int target, int index) {
    int count = 0;

    if (index == numbers.length && sum(numbers) == target) {
      return count + 1;
    } else if (index == numbers.length) {
      return count;
    }

    count += dfs(numbers, target, index + 1);
    numbers[index] = -numbers[index];
    count += dfs(numbers, target, index + 1);

    return count;
  }

  private int sum(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
