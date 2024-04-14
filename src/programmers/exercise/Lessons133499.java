package programmers.exercise;

public class Lessons133499 {
  public static void main(String[] args) {
    System.out.println(new Lessons133499().solution(new String[]{"aya", "yee", "u", "maa"}));
    System.out.println(new Lessons133499().solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
  }

  public int solution(String[] babbling) {
    String[] canWords = new String[]{"aya", "ye", "woo", "ma"};

    int count = 0;

    for (String b : babbling) {
      for (String canWord : canWords) {
        if (b.contains(canWord.repeat(2))) {
          break;
        }
        b = b.replace(canWord, " ");
      }
      if (b.trim().isEmpty()) {
        count++;
      }
    }

    return count;
  }
}
