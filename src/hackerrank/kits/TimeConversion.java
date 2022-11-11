package hackerrank.kits;

public class TimeConversion {
  public static void main(String[] args) {
    System.out.println(timeConversion("07:05:45PM"));
    System.out.println(timeConversion("12:01:00PM"));
    System.out.println(timeConversion("12:01:00AM"));
  }

  public static String timeConversion(String s) {
    int len = s.length();
    String[] times = s.substring(0, len - 2).split(":");
    int hour = Integer.parseInt(times[0]);
    if (s.endsWith("PM") && hour != 12) {
      hour += 12;
    } else if (s.endsWith("AM") && hour == 12) {
      hour -= 12;
    }
    return String.format("%02d:%s:%s", hour, times[1], times[2]);
  }
}
