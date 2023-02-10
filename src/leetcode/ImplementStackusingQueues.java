package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
  class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
      this.queue1 = new LinkedList<>();
      this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
      queue1.offer(x);
    }

    public int pop() {
      int i = 0;
      while (i < queue1.size() - 1) {
        queue2.offer(queue1.poll());
      }
      int val = queue1.poll();
      while (!queue2.isEmpty()) {
        queue1.offer(queue2.poll());
      }
      return val;
    }

    public int top() {
      int i = 0;
      while (i < queue1.size() - 1) {
        queue2.offer(queue1.poll());
      }
      int val = queue1.poll();
      while (!queue2.isEmpty()) {
        queue1.offer(queue2.poll());
      }
      queue1.offer(val);
      return val;
    }

    public boolean empty() {
      return queue1.isEmpty();
    }
  }

  public static void main(String[] args) {
    ImplementStackusingQueues solution = new ImplementStackusingQueues();
    MyStack stack = solution.new MyStack();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.top());
    System.out.println(stack.pop());
  }
}
