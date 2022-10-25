package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
  public static void main(String[] args) {
//    System.out.println(new SimplifyPath().simplifyPath("/home/"));
//    System.out.println(new SimplifyPath().simplifyPath("/../"));
    System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
  }

  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String p : paths) {
      if (p.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (!p.equals(".") && !p.equals("") && !p.equals("..")) {
        stack.push(p);
      }
    }

    StringBuilder builder = new StringBuilder();

    if (stack.isEmpty()) {
      return "/";
    }

    Stack<String> resultStack = new Stack<>();

    while (!stack.isEmpty()) {
      resultStack.push(stack.pop());
    }

    while (!resultStack.isEmpty()) {
      builder.append("/").append(resultStack.pop());
    }

    return builder.toString();
  }
}
