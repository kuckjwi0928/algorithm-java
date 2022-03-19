package programmers.kit;

import java.util.*;
import java.util.stream.Collectors;

public class Disk {
  public static void main(String[] args) {
    System.out.println(new Disk().solution(new int[][]{{1,9}, {2,6}, {0,3}}));
  }

  private static class Job implements Comparable<Job> {
    private final int startTime;

    private final int workingTime;

    public Job(int startTime, int workingTime) {
      this.startTime = startTime;
      this.workingTime = workingTime;
    }

    @Override
    public int compareTo(Job other) {
      if (workingTime == other.workingTime) {
        return Integer.compare(startTime, other.startTime);
      }
      return Integer.compare(workingTime, other.workingTime);
    }

    @Override
    public String toString() {
      return this.startTime + ":" + this.workingTime;
    }
  }

  public int solution(int[][] jobs) {
    List<Job> list = Arrays.stream(jobs)
            .map(job -> new Job(job[0], job[1]))
            .sorted()
            .collect(Collectors.toList());

    int time = 0;
    int sum = 0;

    while (!list.isEmpty()) {
      int index = 0;

      for (Job job : list) {
        if (job.startTime <= time) {
          time += job.workingTime;
          sum += time - job.startTime;
          list.remove(index);
          break;
        }

        if (index == list.size() - 1) {
          time++;
        }

        index++;
      }
    }

    return sum / jobs.length;
  }
}
