package book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentLowScore {
  private static class Student implements Comparable<Student> {
    private final String name;

    private final int score;

    private Student(String name, int score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public int compareTo(Student o) {
      return Integer.compare(this.score, o.score);
    }

    @Override
    public String toString() {
      return String.format("%s %d", name, score);
    }
  }

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>(List.of(
        new Student("홍길동", 95),
        new Student("이순신", 77)
    ));
    new StudentLowScore().solution(students);
    System.out.println(students);
  }

  public void solution(List<Student> students) {
    students.sort(Comparator.naturalOrder());
  }
}
