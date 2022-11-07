package hackerrank.structure;

import java.util.Stack;

public class BalancedBrackets {
  public static void main(String[] args) {
    System.out.println(isBalanced("{[()]}"));
    System.out.println(isBalanced("{[(])}"));
    System.out.println(isBalanced("{{[[(())]]}}"));
    System.out.println(isBalanced("{()"));
    System.out.println(isBalanced(")"));
  }

  public static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
        continue;
      }
      if (stack.isEmpty()) {
        return "NO";
      }
      char open = stack.peek();
      if (c == ')' && open != '(') {
        return "NO";
      } else if (c == ']' && open != '[') {
        return "NO";
      } else if (c == '}' && open != '{') {
        return "NO";
      }
      stack.pop();
    }
    return stack.isEmpty() ? "YES" : "NO";
  }
}
