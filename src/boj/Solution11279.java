package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution11279 {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      Heap heap = new Heap();
      int N = Integer.parseInt(br.readLine());
      for (int i = 0; i < N; i++) {
        int x = Integer.parseInt(br.readLine());
        if (x > 0) {
          heap.add(x);
        } else {
          System.out.println(heap.delete());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static class Heap {
    private final List<Integer> list;

    public Heap() {
      list = new ArrayList<>();
      list.add(-1);
    }

    public void add(int val) {
      list.add(val);
      int index = list.size() - 1;
      while (index > 1 && list.get(index) > list.get(index / 2)) {
        int parentIndex = index / 2;
        int temp = list.get(parentIndex);
        list.set(parentIndex, list.get(index));
        list.set(index, temp);
        index = parentIndex;
      }
    }

    public int delete() {
      int size = list.size();

      if (size - 1 < 1) {
        return 0;
      }

      int prevRoot = list.get(1);
      int lastIndex = size - 1;
      int index = 1;

      list.set(1, list.get(lastIndex));
      list.remove(lastIndex);

      size = list.size();

      while (index * 2 < size) {
        int newIndex = index * 2;

        int value = list.get(newIndex);
        int right = newIndex + 1;

        if (right < size && value < list.get(right)) {
          value = list.get(right);
          newIndex = right;
        }

        if (list.get(index) > value) {
          break;
        }

        int temp = list.get(index);
        list.set(index, value);
        list.set(newIndex, temp);

        index = newIndex;
      }

      return prevRoot;
    }

    @Override
    public String toString() {
      return list.toString();
    }
  }
}
