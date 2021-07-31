package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TrainingClothe {
  public static void main(String[] args) {
    new TrainingClothe().solution(5, new int[]{1,2,4}, new int[]{1,3,5});
    new TrainingClothe().solution(5, new int[]{2,4}, new int[]{3});
    new TrainingClothe().solution(3, new int[]{3}, new int[]{1});
  }


  public int solution(int n, int[] lost, int[] reserve) {
    Set<Integer> originLostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
    Set<Integer> originReserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

    Set<Integer> lostSet = originLostSet.stream().filter(l -> !originReserveSet.contains(l)).collect(Collectors.toSet());
    Set<Integer> reserveSet = originReserveSet.stream().filter(r -> !originLostSet.contains(r)).collect(Collectors.toSet());

    for (int reserveStudent : reserveSet) {
      if (lostSet.contains(reserveStudent - 1)) {
        lostSet.remove(reserveStudent - 1);
      } else if (lostSet.contains(reserveStudent + 1)) {
        lostSet.remove(reserveStudent + 1);
      }
    }

    return n - lostSet.size();
  }
}
