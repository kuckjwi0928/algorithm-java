package codility.lesson;

public class FrogJmp {
  public static void main(String[] args) {
    System.out.println(FrogJmp.solution(10, 85, 30));
    System.out.println(FrogJmp.solution(3, 999111321, 7));
  }
  public static int solution(int X, int Y, int D) {
    return (int) Math.ceil((Y - X) / (double) D);
  }
}
