package leetcode;

import java.util.Arrays;

public class PlusOne {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1,2,3})));
    System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{4,3,2,2})));
    System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9})));
    System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{8,9,9,9})));
  }

  public int[] plusOne(int[] digits) {
    var carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] == 9) {
        digits[i] = 0;
        carry = 1;
      } else {
        digits[i] += carry == 0 ? 1 : carry;
        carry = 0;
      }
      if (carry == 0) {
        break;
      }
    }

    if (carry == 1) {
      var newDigits = new int[digits.length + 1];
      newDigits[0] = 1;
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      return newDigits;
    }

    return digits;
  }
}
