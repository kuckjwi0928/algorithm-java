package leetcode;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
  private final static Set<Character> OPEN = Set.of('{', '[', '(');

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("()()"));
    System.out.println(new ValidParentheses().isValid("(){}[]"));
    System.out.println(new ValidParentheses().isValid("[[]]"));
    System.out.println(new ValidParentheses().isValid("["));
    System.out.println(new ValidParentheses().isValid("(("));

  }

  public boolean isValid(String s) {
    char[] chars = s.toCharArray();

    Stack<Character> stack = new Stack<>();

    for (char c : chars) {
      if (OPEN.contains(c)) {
        stack.push(c);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      char o = stack.pop();

      if ((o == '(' && c != ')') || (o == '{' && c != '}') || (o == '[' && c != ']')) {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
