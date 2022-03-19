package programmers.kit;

public class StockPrice {
  public static void main(String[] args) {
    int[] prices = new int[]{1, 2, 3, 2, 2};
    new StockPrice().solution(prices);
  }

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    int len = prices.length;

    for (int i = 0; i < len; i++) {
      int check = 0;
      int j = i + 1;
      while (j < len) {
        check++;
        if (prices[i] > prices[j]) {
          break;
        }
        j++;
      }
      answer[i] = check;
    }

    return answer;
  }
}
