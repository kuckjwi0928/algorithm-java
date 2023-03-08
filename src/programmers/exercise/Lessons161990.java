package programmers.exercise;

import java.util.Arrays;

public class Lessons161990 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons161990().solution(new String[]{".#...", "..#..", "...#."})));
    System.out.println(Arrays.toString(new Lessons161990().solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
    System.out.println(Arrays.toString(new Lessons161990().solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
  }

  public int[] solution(String[] wallpaper) {
    var start = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    var end = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int i = 0; i < wallpaper.length; i++) {
      for (int j = 0; j < wallpaper[i].length(); j++) {
        if (wallpaper[i].charAt(j) == '#') {
          start[0] = Math.min(start[0], i);
          start[1] = Math.min(start[1], j);
          end[0] = Math.max(end[0], i + 1);
          end[1] = Math.max(end[1], j + 1);
        }
      }
    }
    return new int[]{start[0], start[1], end[0], end[1]};
  }
}
