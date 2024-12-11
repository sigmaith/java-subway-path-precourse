package subway.view;

import java.util.List;
import subway.domain.EdgeRepository;

public class OutputView {

    public void printInquiryResult(List<String> shortestPath) {
        System.out.println("## 조회 결과\n"
                + "[INFO] ---");
        System.out.println(String.format("[INFO] 총 거리: %dkm\n"
                        + "[INFO] 총 소요 시간: %d분", EdgeRepository.getWholeDistance(shortestPath),
                EdgeRepository.getWholeTime(shortestPath)));
        System.out.println("[INFO] ---");
        shortestPath.forEach(station -> System.out.printf("[INFO] %s\n", station));
        System.out.println();
    }
}
