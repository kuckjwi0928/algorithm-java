package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
  public static void main(String[] args) {
    System.out.println(new GenerateParentheses().generateParenthesis(3));
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new LinkedList<>();
    backtrack(result, "", 0, 0, n);
    return result;
  }

  public void backtrack(List<String> result, String s, int open, int close, int max) {
    if (s.length() == max * 2) {
      result.add(s);
      return;
    }
    if (open < max) {
      backtrack(result, s + "(", open + 1, close, max);
    }
    if (close < open) {
      backtrack(result, s + ")", open, close + 1, max);
    }
  }
}
