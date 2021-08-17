package leetcode;

public class RemoveElement {
  public static void main(String[] args) {
    System.out.println(new RemoveElement().removeElement(new int[]{3,2,2,3}, 3));
    System.out.println(new RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
  }

  public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
        k++;
      }
    }
    return k;
  }
}
