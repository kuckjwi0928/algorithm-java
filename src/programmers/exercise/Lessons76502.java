package programmers.exercise;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Lessons76502 {
  public static void main(String[] args) {
    System.out.println(new Lessons76502().solution("[](){}"));
    System.out.println(new Lessons76502().solution("}]()[{"));
    System.out.println(new Lessons76502().solution("[)(]"));
    System.out.println(new Lessons76502().solution("}}}"));
  }

  public int solution(String s) {
    var count = 0;
    var builder = new StringBuilder(s);

    for (int i = 0; i < s.length(); i++) {
      final var firstChar = builder.charAt(0);
      builder.deleteCharAt(0)
              .append(firstChar);
      var stack = new Stack<Character>();
      var index = 0;

      for (final var c : builder.toString().toCharArray()) {
        if (c == '[' || c == '{' || c == '(') {
          stack.push(c);
        } else {
          if (stack.isEmpty()) {
            break;
          }
          if (c == ']' &&  stack.peek() == '[') {
            stack.pop();
          } else if (c == '}' && stack.peek() == '{') {
            stack.pop();
          } else if (c == ')' && stack.peek() == '(') {
            stack.pop();
          }
        }
        index++;
      }

      if (stack.isEmpty() && index == builder.length()) {
        count++;
      }
    }

    return count;
  }
}
