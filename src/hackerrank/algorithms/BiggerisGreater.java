package hackerrank.algorithms;

import java.util.Arrays;

public class BiggerisGreater {
  public static void main(String[] args) {
    System.out.println(biggerIsGreater("ab"));
    System.out.println(biggerIsGreater("bb"));
    System.out.println(biggerIsGreater("hefg"));
    System.out.println(biggerIsGreater("dhck"));
    System.out.println(biggerIsGreater("dkhc"));
    System.out.println(biggerIsGreater("lmno"));
    System.out.println(biggerIsGreater("abdc"));
  }

  public static String biggerIsGreater(String w) {
    final var words = w.toCharArray();
    var end = words.length - 1;

    for (; end > 0; end--) {
      if (words[end] > words[end - 1]) {
        break;
      }
    }

    if (end == 0) {
      return "no answer";
    }

    var smallCharIndex = end - 1;
    var nextSmallCharIndex = end;

    for (int i = end + 1; i < words.length; i++) {
      if (words[i] > words[smallCharIndex] && words[i] < words[nextSmallCharIndex]) {
        nextSmallCharIndex = i;
      }
    }

    swap(words, end - 1, nextSmallCharIndex);

    Arrays.sort(words, end, words.length);

    return new String(words);
  }

  private static void swap(char[] words, int i, int j) {
    char temp = words[i];
    words[i] = words[j];
    words[j] = temp;
  }
}
