package codility.lesson;

public class StrStr {
  public static void main(String[] args) {
    System.out.println(new StrStr().strStr("hello", "ll"));
    System.out.println(new StrStr().strStr("ll", "ll"));
    System.out.println(new StrStr().strStr("ll", "ls"));
    System.out.println(new StrStr().strStr("aaaaa", "bba"));
    System.out.println(new StrStr().strStr("abb", "aaaa"));
    System.out.println(new StrStr().strStr("", ""));
  }

  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }

    char[] haystacks = haystack.toCharArray();
    char[] needles = needle.toCharArray();
    char first = needles[0];

    int max = haystacks.length - needles.length;

    for (int i = 0; i <= max; i++) {
      while (i <= max && haystacks[i] != first) {
        i++;
      }
      if (i <= max) {
        int j = i + 1;
        int end = j + needles.length - 1;
        for (int k = 1; j < end && haystacks[j] == needles[k]; k++) {
          j++;
        }
        if (j == end) {
          return i;
        }
      }
    }

    return -1;
  }
}
