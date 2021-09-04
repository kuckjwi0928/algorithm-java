package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
  public static void main(String[] args) {
    new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7,8,8,8,8,10}, 8);
    new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 6);
    new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{}, 6);
    new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1}, 1);
    new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{2,2}, 2);
  }

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int index = -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        index = mid;
        break;
      }
    }

    int first = index;
    int last = index;

    while (first > 0 && nums[first] == nums[first - 1]) {
      first--;
    }

    while (last >= 0 && last < nums.length - 1 && nums[last] == nums[last + 1]) {
      last++;
    }

    return new int[]{first, last};
  }
}
