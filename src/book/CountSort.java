package book;

import java.util.Arrays;

public class CountSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new CountSort().countSort(new int[]{7,5,9,0,3,1,6,2,9,1,4,8,0,5,2})));
  }

  public int[] countSort(int[] arr) {
    int[] count = new int[arr.length + 1];
    int[] newArr = new int[arr.length];
    for (int i : arr) {
      count[i]++;
    }
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i]; j++) {
        newArr[index] = i;
        index++;
      }
    }
    return newArr;
  }
}
