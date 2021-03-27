package codility;

public class OddOccurrencesInArray {
  public static void main(String[] args) {
    System.out.println(OddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
  }
  public static int solution(int[] A) {
    int check = 0;
    for (int i = 0; i < A.length; i++) {
      check = check ^ A[i];
    }
    return check;
  }
}
