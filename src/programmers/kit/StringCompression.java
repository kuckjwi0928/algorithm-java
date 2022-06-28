package programmers.kit;

public class StringCompression {
  public static void main(String[] args) {
    new StringCompression().solution("aabbaccc");
    new StringCompression().solution("ababcdcdababcdcd");
    new StringCompression().solution("abcabcdede");
    new StringCompression().solution("abcabcabcabcdededededede");
    new StringCompression().solution("xababcdcdababcdcd");
    new StringCompression().solution("ab");
    new StringCompression().solution("a");
  }
  public int solution(String s) {
    int answer = Integer.MAX_VALUE;
    int term = 1;
    int len = s.length();
    if (len == 1) {
      return 1;
    }
    int limit = len / 2;
    while (term <= limit) {
      int count = 1;
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < len; i = i + term) {
        String curr = s.substring(i, Math.min(i + term, len));
        String next = s.substring(Math.min(i + term, len), Math.min(i + term + term, len));
        if (curr.equals(next)) {
          count++;
        } else {
          builder.append(count > 1 ? count : "").append(curr);
          count = 1;
        }
      }
      answer = Math.min(answer, builder.length());
      term++;
    }
    return answer;
  }
}
