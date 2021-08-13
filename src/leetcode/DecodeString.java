package leetcode;

import java.util.Stack;

public class DecodeString {
  public static void main(String[] args) {
    System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    System.out.println(new DecodeString().decodeString("4[a2[c]]"));
    System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
  }

  public String decodeString(String s) {
    Stack<Integer> digitStack = new Stack<>();
    Stack<String> stack = new Stack<>();
    StringBuilder currBuilder = new StringBuilder();

    int num = 0;
    char[] chars = s.toCharArray();

    for(char ch : chars){
      if (Character.isDigit(ch)){
        num = num * 10 + Character.getNumericValue(ch);
      } else if (ch == '['){
        stack.push(currBuilder.toString());
        digitStack.push(num);
        num = 0;
        currBuilder = new StringBuilder();
      } else if (ch == ']') {
        int digit = digitStack.pop();
        currBuilder = new StringBuilder(stack.pop() + currBuilder.toString().repeat(digit));
      } else {
        currBuilder.append(ch);
      }
    }

    return currBuilder.toString();
  }

//  public String decodeString(String s) {
//    Queue<Character> queue = new LinkedList<>();
//    for (char c : s.toCharArray()) {
//      queue.offer(c);
//    }
//    return decode(queue);
//  }
//
//  private String decode(Queue<Character> queue) {
//    StringBuilder builder = new StringBuilder();
//    int num = 0;
//    while (!queue.isEmpty()) {
//      char ch = queue.poll();
//
//      if (Character.isDigit(ch)) {
//        num = num * 10 + Character.getNumericValue(ch);
//        continue;
//      }
//
//      if (ch == '[') {
//        String s = decode(queue);
//        builder.append(s.repeat(Math.max(0, num)));
//        num = 0;
//        continue;
//      }
//
//      if (ch == ']') {
//        break;
//      }
//
//      builder.append(ch);
//    }
//
//    return builder.toString();
//  }
}
