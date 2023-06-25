package leetcode;

// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
  public static void main(String[] args) {
    FindPeakElement obj = new FindPeakElement();
    System.out.println(obj.findPeakElement(new int[]{1, 2, 3, 1}));
    System.out.println(obj.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
  }

  public int findPeakElement(int[] nums) {
    var left = 0;
    var right = nums.length - 1;
    while (left < right) {
      int mid1 = (left + right) / 2;
      int mid2 = mid1 + 1;
      if (nums[mid1] < nums[mid2]) {
        left = mid2;
      } else {
        right = mid1;
      }
    }
    return left;
  }
}
