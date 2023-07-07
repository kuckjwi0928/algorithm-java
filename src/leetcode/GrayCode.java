package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/gray-code
public class GrayCode {
  public static void main(String[] args) {
    System.out.println(new GrayCode().grayCode(2));
  }
  public List<Integer> grayCode(int n) {
    var result = new ArrayList<Integer>();
    for (var i = 0; i < 1 << n; i++) {
      result.add(i ^ i >> 1);
    }
    return result;
  }
}
