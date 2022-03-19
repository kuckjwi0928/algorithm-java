package programmers.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReportResult {
  static class ReportModel {
    private final Set<String> reportUsers;

    public ReportModel() {
      this.reportUsers = new HashSet<>();
    }

    public boolean isExistReport(String reportUser) {
      return this.reportUsers.contains(reportUser);
    }

    public void report(String reportUser) {
      this.reportUsers.add(reportUser);
    }

    @Override
    public String toString() {
      return "reportUsers=" + this.reportUsers;
    }
  }

  public int[] solution(String[] id_list, String[] reports, int k) {
    int[] answer = new int[id_list.length];

    Map<String, ReportModel> reportMap = new HashMap<>();
    Map<String, Integer> mailerMap = new HashMap<>();

    for (String id : id_list) {
      reportMap.put(id, new ReportModel());
    }

    for (String report : reports) {
      String[] reportUsers = report.split("\\s");
      ReportModel reportModel = reportMap.get(reportUsers[1]);
      if (reportModel.isExistReport(reportUsers[0])) {
        continue;
      }
      reportModel.report(reportUsers[0]);
    }

    for (ReportModel reportModel : reportMap.values()) {
      if (reportModel.reportUsers.size() < k) {
        continue;
      }
      for (String reporter : reportModel.reportUsers) {
        mailerMap.put(reporter, mailerMap.getOrDefault(reporter, 0) + 1);
      }
    }

    for (int i = 0; i < id_list.length; i++) {
      answer[i] = mailerMap.getOrDefault(id_list[i], 0);
    }

    return answer;
  }

  public static void main(String[] args) {
    new ReportResult().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi", "neo frodo"}, 2);
    new ReportResult().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
  }
}
