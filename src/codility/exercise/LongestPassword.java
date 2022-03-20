package codility.exercise;

public class LongestPassword {
  public static void main(String[] args) {
    System.out.println(new LongestPassword().solution("test 5 a0A pass007 ?xy1"));
    System.out.println(new LongestPassword().solution("123456"));
    System.out.println(new LongestPassword().solution("zaq!2#edc"));
    System.out.println(new LongestPassword().solution("4adf4dsk45"));
  }

  public int solution(String S) {
    String[] passwords = S.split(" ");
    int max = -1;
    for (String password : passwords) {
      int numCount = 0;
      int textCount = 0;
      boolean ugly = false;
      for (char c : password.toCharArray()) {
        if (!Character.isDigit(c) && !Character.isLetter(c)) {
          ugly = true;
          break;
        }
        if (Character.isDigit(c)) {
          numCount++;
        } else {
          textCount++;
        }
      }
      boolean evenWord = textCount % 2 == 0;
      boolean oddNum = numCount % 2 == 1;
      if (!ugly && (evenWord && oddNum)) {
        max = Math.max(max, password.length());
      }
    }
    return max;
  }
}
