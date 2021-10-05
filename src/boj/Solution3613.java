package boj;

import java.util.Scanner;

public class Solution3613 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      char[] inputs = sc.nextLine().toCharArray();
      StringBuilder builder = new StringBuilder();

      boolean cpp = false;
      boolean java = false;
      boolean error = false;

      for (int i = 0; i < inputs.length; i++) {
        if (Character.isUpperCase(inputs[i])) {
          if (i == 0 || cpp) {
            error = true;
            break;
          }
          builder.append('_').append((char) (inputs[i] + 32));
          java = true;
        } else if (inputs[i] == '_') {
          if (i == 0 || i == inputs.length - 1 || java || inputs[i + 1] == '_' || Character.isUpperCase(inputs[i + 1])) {
            error = true;
            break;
          }
          builder.append((char) (inputs[i + 1] - 32));
          cpp = true;
          i++;
        } else {
          builder.append(inputs[i]);
        }
      }
      System.out.println(error ? "Error!" : builder.toString());
    }
  }
}
