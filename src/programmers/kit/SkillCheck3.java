package programmers.kit;

//자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//n은 1 이상 100,000,000 이하인 자연수입니다.
//입출력 예
//n	result
//45	7
//125	229
//입출력 예 설명
//입출력 예 #1
//
//답을 도출하는 과정은 다음과 같습니다.
//n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//45	1200	0021	7
//따라서 7을 return 해야 합니다.
//입출력 예 #2
//
//답을 도출하는 과정은 다음과 같습니다.
//n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//125	11122	22111	229
public class SkillCheck3 {
  public static void main(String[] args) {
    solution(45);
  }

  public static int solution(int n) {
    StringBuilder builder = new StringBuilder();

    int divide = n;

    while (divide != 0) {
      builder.append(divide % 3);
      divide = divide / 3;
    }

    char[] arr = builder.toString().toCharArray();

    int exec = 1;
    int sum = 0;

    for (int i = arr.length - 1; i >= 0; i--) {
      sum = sum + Character.getNumericValue(arr[i]) * exec;
      exec = exec * 3;
    }

    return sum;
  }
}
