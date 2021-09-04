package leetcode;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    System.out.println(new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    System.out.println(new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2,3}, 1));
  }

  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    if (nums[0] == target) {
      return 0;
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > nums[high]) {
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (nums[mid] < nums[low]){
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if (nums[mid] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }
}
