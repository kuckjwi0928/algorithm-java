package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1}));
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{2}, new int[]{}));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> list = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed())
      .sorted(Integer::compare)
      .collect(Collectors.toList());

    boolean mod = list.size() % 2 == 0;
    int divide = list.size() / 2;

    return (double) IntStream.rangeClosed(mod ? divide - 1 : divide, divide).map(list::get).sum() / (mod ? 2 : 1);
  }
}
