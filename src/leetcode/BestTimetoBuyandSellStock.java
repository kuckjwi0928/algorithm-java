package leetcode;

public class BestTimetoBuyandSellStock {
  public static void main(String[] args) {
    System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }

  public int maxProfit(int[] prices) {
    int far = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      far = Math.min(far, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - far);
    }
    return maxProfit;
  }
}
