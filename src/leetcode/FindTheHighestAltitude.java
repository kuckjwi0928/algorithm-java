package leetcode;

// https://leetcode.com/problems/find-the-highest-altitude/description/
public class FindTheHighestAltitude {
  public static void main(String[] args) {
    System.out.println(new FindTheHighestAltitude().largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    System.out.println(new FindTheHighestAltitude().largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
  }

  public int largestAltitude(int[] gain) {
    for (var i = 0; i < gain.length - 1; i++) {
      gain[i + 1] += gain[i];
    }
    var max = 0;
    for (var i : gain) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }
}
