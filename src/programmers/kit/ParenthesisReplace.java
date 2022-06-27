package programmers.kit;

public class ParenthesisReplace {
  public static void main(String[] args) {
    System.out.println(new ParenthesisReplace().solution("(()())()"));
    System.out.println(new ParenthesisReplace().solution("()"));
    System.out.println(new ParenthesisReplace().solution("()))((()"));
  }

  public String solution(String p) {
    if (p.isEmpty()) {
      return "";
    }
    return process(p, getBalance(p));
  }

  private String process(String p, int index) {
    if (isValid(p)) {
      return p;
    }
    String u = p.substring(0, index);
    String v = p.substring(index);
    if (isValid(u)) {
      return u + process(v, getBalance(v));
    }
    return "(" + process(v, getBalance(v)) + ")" + removeAndReverse(u);
  }

  private int getBalance(String p) {
    int i;
    int open = 0;
    int close = 0;
    for (i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '(') {
        open++;
      } else {
        close++;
      }
      if (open == close) {
        return i + 1;
      }
    }
    return i;
  }

  private String removeAndReverse(String p) {
    String result = p.substring(1, p.length() - 1);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < result.length(); i++) {
      builder.append(result.charAt(i) == '(' ? ')' : '(');
    }
    return builder.toString();
  }

  private boolean isValid(String p) {
    int count = 0;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }
}
