package leetcode;

public class ShortestWordDistance {
  public static void main(String[] args) {
    System.out.println(new ShortestWordDistance().shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
    System.out.println(new ShortestWordDistance().shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
  }

  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    var w1 = -1;
    var w2 = -1;
    var maxDistance = wordsDict.length;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        w1 = i;
      }
      if (wordsDict[i].equals(word2)) {
        w2 = i;
      }
      if (w1 != -1 && w2 != -1) {
        maxDistance = Math.min(maxDistance, Math.abs(w1 - w2));
      }
    }
    return maxDistance;
  }
}
