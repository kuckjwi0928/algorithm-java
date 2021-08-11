package leetcode;

public class ContainerWithMostWater {
  public static void main(String[] args) {
    System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    System.out.println(new ContainerWithMostWater().maxArea(new int[]{4,3,2,1,4}));
    System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,2,1}));
  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = Integer.MIN_VALUE;
    while (left != right) {
      int distance = right - left;
      if (height[left] <= height[right]) {
        max = Math.max(max, distance * height[left]);
        left++;
      } else {
        max = Math.max(max, distance * height[right]);
        right--;
      }
    }
    return max;
  }
}
