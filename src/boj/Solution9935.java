package boj;

import java.util.Scanner;

public class Solution9935 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println(solution(scan.next(), scan.next()));
    }
  }

  public static String solution(String word, String bomb) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      sb.append(word.charAt(i));
      if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
        System.out.println(sb);
        System.out.println(sb.substring(sb.length() - bomb.length()));
        sb.delete(sb.length() - bomb.length(), sb.length());
      }
    }
    return sb.length() == 0 ? "FRULA" : sb.toString();
  }
}
