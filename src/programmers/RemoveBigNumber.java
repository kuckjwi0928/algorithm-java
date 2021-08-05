package programmers;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveBigNumber {
  public static void main(String[] args) {
    System.out.println(new RemoveBigNumber().solution("1231234", 3));
  }

  public String solution(String number, int k) {
    char[] chars = number.toCharArray();
    Stack<Integer> stack = new Stack<>();

    for (char c : chars) {
      int num = Character.getNumericValue(c);
      while (!stack.isEmpty() && stack.peek() < num && k-- > 0) {
        stack.pop();
      }
      stack.push(num);
    }

    return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
  }
}
