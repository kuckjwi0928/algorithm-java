package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          continue;
        }

        int subBox = 3 * (i / 3) + j / 3;
        int num = Character.getNumericValue(board[i][j]);

        String rowKey = "row-" + num + i;
        String colKey = "col-" + num + j;
        String subBoxKey = "sub-" + num + subBox;

        if (set.contains(rowKey) || set.contains(colKey) || set.contains(subBoxKey)) {
          return false;
        }

        set.add(rowKey);
        set.add(colKey);
        set.add(subBoxKey);
      }
    }
    return true;
  }
}
