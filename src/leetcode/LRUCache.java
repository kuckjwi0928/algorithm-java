package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
  private final Map<Integer, Integer> map;

  public LRUCache(int capacity) {
    this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
      public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
      }
    };
  }

  public int get(int key) {
    return this.map.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    this.map.put(key, value);
  }

  @Override
  public String toString() {
    return this.map.toString();
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
  }
}
