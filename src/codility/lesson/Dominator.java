package codility.lesson;

// https://app.codility.com/programmers/lessons/8-leader/dominator/
public class Dominator {
  public static void main(String[] args) {
    var A = new int[]{3, 4, 3, 2, 3, -1, 3, 3};
    var dominator = new Dominator();
    System.out.println(dominator.solution(A));
  }

  public int solution(int[] A) {
    var size = 0;
    var value = 0;

    for (int i : A) {
      if (size == 0) {
        size++;
        value = i;
      } else {
        if (value != i) {
          size--;
        } else {
          size++;
        }
      }
    }

    var candidate = -1;
    if (size > 0) {
      candidate = value;
    }

    var count = 0;
    var index = -1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == candidate) {
        count++;
        index = i;
      }
    }

    if (count > A.length / 2) {
      return index;
    }

    return -1;
  }
}
