package book;

import java.util.Arrays;

public class UpDownLeftRight {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(5, "R R R U D D")));
    System.out.println(Arrays.toString(solution(2, "R R R D D D")));
  }

  public static int[] solution(int size, String commandString) {
    String[] commands = commandString.split("\\s");

    int x = 1;
    int y = 1;

    for (String command : commands) {
      int nx = x;
      int ny = y;
      switch (command) {
        case "U":
          ny--;
          break;
        case "D":
          ny++;
          break;
        case "R":
          nx++;
          break;
        case "L":
          nx--;
          break;
      }
      if (nx <= 0 || nx > size || ny > size || ny <= 0) {
        continue;
      }
      x = nx;
      y = ny;
    }
    return new int[]{y, x};
  }
}
