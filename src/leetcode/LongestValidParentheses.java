package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
  private static final char OPEN = '(';

  public static void main(String[] args) {
    System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    System.out.println(new LongestValidParentheses().longestValidParentheses("()(())"));
    System.out.println(new LongestValidParentheses().longestValidParentheses("(()()"));
  }

  public int longestValidParentheses(String s) {
    char[] chars = s.toCharArray();

    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    int max = 0;

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == OPEN) {
        stack.push(i);
        continue;
      }
      stack.pop();
      if (stack.isEmpty()) {
        stack.push(i);
      }
      max = Math.max(max, i - stack.peek());
    }

    return max;
  }
}
