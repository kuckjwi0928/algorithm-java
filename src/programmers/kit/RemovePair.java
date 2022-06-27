package programmers.kit;

import java.util.Stack;

public class RemovePair {
  public static void main(String[] args) {
    new RemovePair().solution("baabaa");
    new RemovePair().solution("cdcd");
  }

  public int solution(String s) {
    char[] chars = s.toCharArray();

    Stack<Character> stack = new Stack<>();

    for (char c : chars) {
      if (!stack.isEmpty() && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }
}
