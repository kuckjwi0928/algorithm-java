package leetcode;

public class RemoveDuplicatesfromSortedArrayII {
  public static void main(String[] args) {
    System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
  }

  public int removeDuplicates(int[] nums) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (index < 2 || nums[i] > nums[index - 2]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }
}
