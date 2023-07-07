package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.com/problems/insert-interval
public class InsertInterval {
    public static void main(String[] args) {
        new InsertInterval().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var i = 0;
        final var results = new LinkedList<int[]>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        results.add(newInterval);
        while (i < intervals.length) {
            results.add(intervals[i++]);
        }
        return results.toArray(new int[results.size()][]);
    }
}
