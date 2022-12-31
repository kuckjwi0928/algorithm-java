package etc;

public class MathExpression {
  private static class Parser {
    private final String str;

    private int pos;
    private int ch;

    public Parser(String str) {
      this.str = str;
      this.pos = -1;
    }

    private void nextChar() {
      this.ch = (++this.pos < this.str.length()) ? this.str.charAt(this.pos) : -1;
    }

    private boolean find(int charToFind) {
      while (Character.isWhitespace(ch)) nextChar();
      if (ch == charToFind) {
        nextChar();
        return true;
      }
      return false;
    }

    private int parseExpression() {
      int x = parseTerm();
      while (true) {
        if (find('+')) x += parseTerm();
        else if (find('-')) x -= parseTerm();
        else return x;
      }
    }

    private int parseTerm() {
      int x = parseFactor();
      while (true) {
        if (find('*')) x *= parseFactor();
        else if (find('/')) x /= parseFactor();
        else return x;
      }
    }

    private int parseFactor() {
      int x = 0;
      int startPos = this.pos;
      if (find('(')) {
        x = parseExpression();
        if (!find(')')) throw new RuntimeException("Missing ')'");
      } else if (Character.isDigit(ch)) {
        while (Character.isDigit(ch)) nextChar();
        x = Integer.parseInt(str.substring(startPos, this.pos).trim());
      }
      return x;
    }

    public int parse() {
      nextChar();
      int x = parseExpression();
      if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
      return x;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Parser("(5 + 5) / 2").parse());
  }
}
