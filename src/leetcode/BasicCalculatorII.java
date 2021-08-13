package leetcode;

import java.util.Stack;

public class BasicCalculatorII {
  public static void main(String[] args) {
    System.out.println(new BasicCalculatorII().calculate("10000+1000"));
    System.out.println(new BasicCalculatorII().calculate("2 * 2 * 2"));
  }

  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int len = s.length();
    Stack<Integer> stack = new Stack<>();
    int curr = 0;
    char operation = '+';

    for (int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        curr = curr * 10 + Character.getNumericValue(ch);
      }
      if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == len - 1) {
        if (operation == '-') {
          stack.push(-curr);
        }
        else if (operation == '+') {
          stack.push(curr);
        }
        else if (operation == '*') {
          stack.push(stack.pop() * curr);
        }
        else if (operation == '/') {
          stack.push(stack.pop() / curr);
        }
        operation = ch;
        curr = 0;
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
