package leetcode;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
  public static void main(String[] args) {
    System.out.println(new MissingNumber().missingNumber(new int[]{3, 0, 1}));
    System.out.println(new MissingNumber().missingNumber(new int[]{0, 1}));
    System.out.println(new MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
  }

  public int missingNumber(int[] nums) {
    var n = nums.length;
    var sum = (n * (n + 1)) / 2;
    for (var num : nums) {
      sum -= num;
    }
    return sum;
  }
}
