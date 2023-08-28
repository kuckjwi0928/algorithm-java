package codility.lesson;

import java.util.Set;
import java.util.Stack;

public class Brackets {
  public static void main(String[] args) {
    var obj = new Brackets();
    System.out.println(obj.solution("{[()()]}"));
    System.out.println(obj.solution("([)()]"));
    System.out.println(obj.solution("))(("));
    System.out.println(obj.solution("())"));
  }

  public int solution(String S) {
    final var chars = S.toCharArray();
    final var stack = new Stack<Character>();
    for (var c : chars) {
      if (Set.of('[', '{', '(').contains(c)) {
        stack.push(c);
        continue;
      }
      if (!stack.isEmpty()) {
        if (c == ')' && stack.peek() == '(') {
          stack.pop();
        } else if (c == '}' && stack.peek() == '{') {
          stack.pop();
        } else if (c == ']' && stack.peek() == '[') {
          stack.pop();
        } else {
          return 0;
        }
      } else {
        return 0;
      }
    }
    return stack.isEmpty() ? 1 : 0;
  }
}
