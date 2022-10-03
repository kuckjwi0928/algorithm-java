package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}});
    new MergeIntervals().merge(new int[][]{{1, 4}, {1, 4}});
    new MergeIntervals().merge(new int[][]{{1, 4}, {0, 4}});
    new MergeIntervals().merge(new int[][]{{1, 4}, {2, 3}});
    new MergeIntervals().merge(new int[][]{{1, 4}, {0, 0}});
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> results = new ArrayList<>();

    int[] values = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > values[1]) {
        results.add(values);
        values = intervals[i];
      } else {
        values[1] = Math.max(values[1], intervals[i][1]);
      }
    }
    results.add(values);
    return results.toArray(new int[results.size()][2]);
  }
}
