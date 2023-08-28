package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
  private Map<String, Integer> map;
  public LoggerRateLimiter() {
    this.map = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    var ts = map.getOrDefault(message, timestamp);
    if (ts > timestamp) {
      return false;
    }
    map.put(message, timestamp + 10);
    return true;
  }

  public static void main(String[] args) {
    var obj = new LoggerRateLimiter();
    System.out.println(obj.shouldPrintMessage(1, "foo"));
    System.out.println(obj.shouldPrintMessage(2, "bar"));
    System.out.println(obj.shouldPrintMessage(3, "foo"));
    System.out.println(obj.shouldPrintMessage(8, "bar"));
    System.out.println(obj.shouldPrintMessage(10, "foo"));
    System.out.println(obj.shouldPrintMessage(11, "foo"));
  }
}
