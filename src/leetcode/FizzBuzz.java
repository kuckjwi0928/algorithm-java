package leetcode;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
  public static void main(String[] args) {
    var obj = new FizzBuzz();
    System.out.println(obj.fizzBuzz(15));
  }

  public List<String> fizzBuzz(int n) {
    var list = new LinkedList<String>();
    for (var i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        list.add("FizzBuzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else {
        list.add(Integer.toString(i));
      }
    }
    return list;
  }
}
