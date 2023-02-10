package leetcode;

import java.util.Stack;

class MinStack {
  private Stack<Integer> stack1;

  private Stack<Integer> stack2;

  public MinStack() {
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }

  public void push(int val) {
    stack1.push(val);
    if (stack2.isEmpty() || val <= stack2.peek()) {
      stack2.push(val);
    }
  }

  public void pop() {
    int val = stack1.pop();
    if (val == stack2.peek()) {
      stack2.pop();
    }
  }

  public int top() {
    return stack1.peek();
  }

  public int getMin() {
    return stack2.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top()); // return 0
    System.out.println(minStack.getMin()); // return -2
  }
}
