package programmers.exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lessons150370 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons150370().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
  }

  private static class Term {
    private String type;

    private int period;

    private Term(String[] term) {
      this.type = term[0];
      this.period = Integer.parseInt(term[1]);
    }

    @Override
    public String toString() {
      return "Term{" +
          "type='" + type + '\'' +
          ", period=" + period +
          '}';
    }
  }

  private static class privacy {
    private int id;

    private LocalDate date;

    private Term term;

    private privacy(int id, String date, Term term) {
      this.id = id;
      this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
      this.term = term;
    }

    @Override
    public String toString() {
      return "privacy{" +
          "id=" + id +
          ", date=" + date +
          ", term=" + term +
          '}';
    }

    public boolean isExpired(LocalDate date) {
      return this.date.plusMonths(term.period).isEqual(date) || this.date.plusMonths(term.period).isBefore(date);
    }
  }


  public int[] solution(String today, String[] terms, String[] privacies) {
    final var termsMap = Arrays.stream(terms)
          .map(s -> s.split(" "))
          .map(Term::new)
          .collect(Collectors.toMap(t -> t.type, Function.identity()));

    final var autoId = new AtomicInteger(0);

    final var p = Arrays.stream(privacies)
        .map(s -> s.split(" "))
        .map(s -> new privacy(autoId.incrementAndGet(), s[0], termsMap.get(s[1])))
        .toList();

    return p.stream()
            .filter(privacy -> privacy.isExpired(LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"))))
            .mapToInt(privacy -> privacy.id)
            .toArray();
  }
}
