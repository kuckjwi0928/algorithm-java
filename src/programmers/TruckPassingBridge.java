package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class TruckPassingBridge {
  public static void main(String[] args) {
    new TruckPassingBridge().solution(2, 10, new int[]{7,4,5,6});
    new TruckPassingBridge().solution(100, 100, new int[]{10});
    new TruckPassingBridge().solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    LinkedList<Integer> standByQueue = Arrays.stream(truck_weights)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
    LinkedList<Integer> passingQueue = new LinkedList<>();

    int time = 0;
    int currentWeight = 0;

    while (!standByQueue.isEmpty()) {
      if (passingQueue.size() == bridge_length) {
        currentWeight -= passingQueue.poll();
        continue;
      }

      if (standByQueue.peek() + currentWeight > weight) {
        passingQueue.offer(0);
        time++;
        continue;
      }

      int weightOfTruck = standByQueue.poll();
      passingQueue.offer(weightOfTruck);
      currentWeight += weightOfTruck;
      time++;
    }

    return time + bridge_length;
  }
}
