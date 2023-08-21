package leetcode;

public class ReverseVowelsofaString {
  public static void main(String[] args) {
    var obj = new ReverseVowelsofaString();
    System.out.println(obj.reverseVowels("hello"));
    System.out.println(obj.reverseVowels("leetcode"));
  }

  public String reverseVowels(String s) {
    final var vowels = "aeiouAEIOU";
    var chars = s.toCharArray();
    var left = 0;
    var right = chars.length - 1;
    while (left < right) {
      while (left < right && !vowels.contains(chars[left] + "")) {
        left++;
      }
      while (left < right && !vowels.contains(chars[right] + "")) {
        right--;
      }
      var temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
    }
    return new String(chars);
  }
}
