package programmers.exercise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
public class Lessons155651 {
  public static void main(String[] args) {
    System.out.println(new Lessons155651().solution(new String[][]{{"00:00", "23:59"}}));
    System.out.println(new Lessons155651().solution(new String[][]{{"15:00", "17:00"}}));
    System.out.println(new Lessons155651().solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    System.out.println(new Lessons155651().solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
    System.out.println(new Lessons155651().solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
  }

  private static class Room {
    private final List<RoomReservation> reservations;

    public Room() {
      this.reservations = new ArrayList<>();
    }

    public void addReservation(RoomReservation reservation) {
      this.reservations.add(reservation);
    }

    public boolean isAvailableReservation(LocalDateTime start, LocalDateTime end) {
      return reservations.stream().noneMatch(reservation -> reservation.isOverlapped(start, end));
    }
  }

  private static class RoomReservation {
    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private RoomReservation(String startedAt, String endedAt) {
      var now = LocalDateTime.now();
      this.startedAt = now.withHour(Integer.parseInt(startedAt.substring(0, 2))).withMinute(Integer.parseInt(startedAt.substring(3, 5))).withSecond(0).withNano(0);
      this.endedAt = now.withHour(Integer.parseInt(endedAt.substring(0, 2))).withMinute(Integer.parseInt(endedAt.substring(3, 5))).withSecond(0).withNano(0).plusMinutes(10);
    }

    @Override
    public String toString() {
      return "RoomReservation{" +
              "startedAt=" + startedAt +
              ", endedAt=" + endedAt +
              '}';
    }

    public boolean isOverlapped(LocalDateTime start, LocalDateTime end) {
      return (start.isEqual(startedAt) && end.isEqual(endedAt)) || (start.isAfter(startedAt) && start.isBefore(endedAt)) || (end.isAfter(startedAt) && end.isBefore(endedAt));
    }

    public LocalDateTime getStartedAt() {
      return startedAt;
    }

    public LocalDateTime getEndedAt() {
      return endedAt;
    }
  }

  public int solution(String[][] book_time) {
    final var reservations = Arrays.stream(book_time)
            .map(t -> new RoomReservation(t[0], t[1]))
            .sorted(Comparator.comparing(RoomReservation::getStartedAt).thenComparing(RoomReservation::getEndedAt, Comparator.reverseOrder()))
            .collect(Collectors.toList());

    final var rooms = new ArrayList<Room>();

    for (final var reservation : reservations) {
      rooms.stream()
        .filter(r -> r.isAvailableReservation(reservation.getStartedAt(), reservation.getEndedAt()))
        .findFirst()
        .ifPresentOrElse(
          r -> r.addReservation(reservation),
          () -> {
            final var newRoom = new Room();
            newRoom.addReservation(reservation);
            rooms.add(newRoom);
          }
        );
    }

    return rooms.size();
  }
}
