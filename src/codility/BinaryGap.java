package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryGap {
  public static void main(String[] args) {
    System.out.println(BinaryGap.solution(32));
  }

  private static int solution(int N) {
    int gapCount = 0;
    List<Integer> gapCounts = new ArrayList<>();
    char[] binaryChars = Integer.toBinaryString(N).toCharArray();;
    for (int i = 0; i < binaryChars.length; i++) {
      if (binaryChars[i] == '0') {
        gapCount = gapCount + 1;
      } else if (i > 0 && binaryChars[i] == '1') {
        gapCounts.add(gapCount);
        gapCount = 0;
      }
    }
    return gapCounts.isEmpty() ? 0 : Collections.max(gapCounts);
  }
}
