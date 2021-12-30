package leetcode;

public class MultiplyStrings {
  public static void main(String[] args) {
    //      12 8 4
    //   15 10 5 0
    // 18 12 6 0 0
    System.out.println(new MultiplyStrings().multiply("321", "654"));
  }

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    StringBuilder builder = new StringBuilder();
    int[] array = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      int n1 = Character.getNumericValue(num1.charAt(i));
      for (int j = num2.length() - 1; j >= 0; j--) {
        int n2 = Character.getNumericValue(num2.charAt(j));
        int sum = array[i + j + 1] + n1 * n2;
        array[i + j + 1] = sum % 10;
        array[i + j] += sum / 10;
      }
    }
    int index = array[0] == 0 ? 1 : 0;
    while (index < array.length) {
      builder.append(array[index]);
      index++;
    }
    return builder.toString();
  }
}
