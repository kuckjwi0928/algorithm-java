package leetcode;

public class Numberof1Bits {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      int bit = n & 1;
      count += bit;
      n = n >>> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Numberof1Bits solution = new Numberof1Bits();
    System.out.println(solution.hammingWeight(0b00000000000000000000000000001011));
    System.out.println(solution.hammingWeight(0b00000000000000000000000010000000));
  }
}
