package leetcode;

public class SortColors {
  public static void main(String[] args) {
    new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
  }

  public void sortColors(int[] nums) {
    int[] count = new int[3];

    for (int num : nums) {
      count[num]++;
    }

    int index = 0;

    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i]; j++) {
        nums[index++] = i;
      }
    }
  }
}
