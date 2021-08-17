package leetcode;

public class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2});
    new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1});
    new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1});
    new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,2});
  }

  public int removeDuplicates(int[] nums) {
    int k = 0;
    int len = nums.length;

    if (len < 2) {
      return len;
    }

    for (int i = 0; i < len - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[k++] = nums[i];
      }
    }

    if (k != 0 && nums[k - 1] != nums[len - 1]) {
      nums[k++] = nums[len - 1];
    }

    return k == 0 ? 1 : k;
  }
}
