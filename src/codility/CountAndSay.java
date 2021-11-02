package codility;

public class CountAndSay {
  public static void main(String[] args) {
    new CountAndSay().countAndSay(5);
  }

  public String countAndSay(int n) {
    String say = "1";

    if (n == 1) {
      return say;
    }

    for (int i = 0; i < n - 1; i++) {
      say = say(say);
    }

    return say;
  }

  private String say(String say) {
    StringBuilder result = new StringBuilder();

    int count = 1;

    char[] says = say.toCharArray();

    for (int i = 0; i < says.length; i++) {
      while (i + 1 < says.length && says[i] == says[i + 1]) {
          count++;
          i++;
      }
      result.append(count).append(says[i]);
      count = 1;
    }

    return result.toString();
  }
}
