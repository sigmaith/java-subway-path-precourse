package subway.view;

import java.util.List;
import subway.domain.EdgeRepository;

public class OutputView {
    private final String RESULT_PREFIX = "## 조회 결과\n"
            + "[INFO] ---";

    private final String WHOLE_DISTANCE_GUIDE = "[INFO] 총 거리: %dkm\n";
    private final String WHOLE_TIME_GUIDE = "[INFO] 총 소요 시간: %d분\n";
    private final String RESULT_SUFFIX = "[INFO] ---";
    private final String SHORTEST_PATH_STATION_GUIDE = "[INFO] %s\n";

    public void printInquiryResult(List<String> shortestPath) {
        System.out.println(RESULT_PREFIX);
        System.out.printf(WHOLE_DISTANCE_GUIDE, EdgeRepository.getWholeDistance(shortestPath));
        System.out.printf(WHOLE_TIME_GUIDE, EdgeRepository.getWholeTime(shortestPath));
        System.out.println(RESULT_SUFFIX);
        shortestPath.forEach(station -> System.out.printf(SHORTEST_PATH_STATION_GUIDE, station));
        System.out.println();
    }
}
