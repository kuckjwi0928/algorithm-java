package leetcode;

public class NextPermutation {
  public static void main(String[] args) {
    new NextPermutation().nextPermutation(new int[]{1,2,3});
    new NextPermutation().nextPermutation(new int[]{3,2,1});
    new NextPermutation().nextPermutation(new int[]{1,2});
    new NextPermutation().nextPermutation(new int[]{1,3,2});
  }

  public void nextPermutation(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    int i = nums.length - 2; // 1
    int j = nums.length - 1; // 2

    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }

    reverse(nums,i + 1,nums.length - 1);
  }

  public void swap (int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void reverse(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i++, j--);
    }
  }
}
