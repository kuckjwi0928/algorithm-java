package leetcode;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/flip-game
public class FlipGame {
  public static void main(String[] args) {
    FlipGame flipGame = new FlipGame();
    String currentState = "++++";
    List<String> possibleNextMoves = flipGame.generatePossibleNextMoves(currentState);
    System.out.println(possibleNextMoves);
  }

  public List<String> generatePossibleNextMoves(String currentState) {
    final var currentStateLength = currentState.length();
    if (currentStateLength < 2) {
      return Collections.emptyList();
    }
    final var possibleNextMoves = new java.util.ArrayList<String>();
    for (int i = 0; i < currentStateLength - 1; i++) {
      if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
        possibleNextMoves.add(String.join("", currentState.substring(0, i), "--", currentState.substring(i + 2)));
      }
    }
    return possibleNextMoves;
  }
}
