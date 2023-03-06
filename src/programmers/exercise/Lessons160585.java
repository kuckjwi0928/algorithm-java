package programmers.exercise;

// https://school.programmers.co.kr/learn/courses/30/lessons/160585
public class Lessons160585 {
  public static void main(String[] args) {
    System.out.println(new Lessons160585().solution(new String[]{"O.X", ".O.", "..X"}));
    System.out.println(new Lessons160585().solution(new String[]{"OOO", "...", "XXX"}));
    System.out.println(new Lessons160585().solution(new String[]{"...", ".X.", "..."}));
    System.out.println(new Lessons160585().solution(new String[]{"...", "...", "..."}));
  }

  public int solution(String[] board) {
    var o = 0;
    var x = 0;
    for (String s : board) {
      for (char c : s.toCharArray()) {
        if (c == 'O') {
          o++;
        } else if (c == 'X') {
          x++;
        }
      }
    }
    var winO = isWin('O', board);
    var winX = isWin('X', board);
    if ((x > o) || (o - x > 1) || (winO && winX) || (winO && o == x) || (winX && o > x)) {
      return 0;
    }
    return 1;
  }

  private boolean isWin(char c, String[] board) {
    var checkString = String.valueOf(c).repeat(3);
    // check rows
    for (String s : board) {
      if (s.equals(checkString)) {
        return true;
      }
    }
    // check cols
    for (int i = 0; i < board.length; i++) {
      var sb = new StringBuilder();
      for (int j = 0; j < board.length; j++) {
        sb.append(board[j].charAt(i));
      }
      if (sb.toString().equals(checkString)) {
        return true;
      }
    }
    // check diagonals
    var left = new StringBuilder();
    var right = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      left.append(board[i].charAt(i));
      right.append(board[i].charAt(2 - i));
    }
    return left.toString().equals(checkString) || right.toString().equals(checkString);
  }
}
