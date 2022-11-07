package hackerrank.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Stack;

public class QueueusingTwoStacks {
  private static class TwoStackQueue<T> extends AbstractQueue<T> {
    private final Stack<T> stack1;
    private final Stack<T> stack2;

    private int size;

    public TwoStackQueue() {
      this.stack1 = new Stack<>();
      this.stack2 = new Stack<>();
    }

    @Override
    public Iterator<T> iterator() {
      throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
      return size;
    }

    public void push(T data) {
      stack1.push(data);
      size++;
    }

    @Override
    public boolean offer(T data) {
      push(data);
      return true;
    }

    @Override
    public T poll() {
      moveStack1ToStack2();
      T data = stack2.pop();
      size--;
      return data;
    }

    @Override
    public T peek() {
      moveStack1ToStack2();
      return stack2.peek();
    }

    private void moveStack1ToStack2() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
    }

    @Override
    public String toString() {
      return this.stack1 + "," + this.stack2;
    }
  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int queries = Integer.parseInt(reader.readLine());
      TwoStackQueue<Integer> twoStackQueue = new TwoStackQueue<>();
      for (int i = 0; i < queries; i++) {
        String line = reader.readLine();
        String[] parts = line.split(" ");
        int query = Integer.parseInt(parts[0]);
        int value = parts.length == 2 ? Integer.parseInt(parts[1]) : 0;
        if (query == 1) {
          twoStackQueue.offer(value);
        } else if (query == 2) {
          twoStackQueue.poll();
        } else {
          System.out.println(twoStackQueue.peek());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
