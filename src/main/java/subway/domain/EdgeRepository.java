package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.exception.CustomException;
import subway.exception.ErrorMessage;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    public static Integer getWholeDistance(List<String> path) {
        int wholeDistance = 0;
        for (int i = 1; i < path.size(); i++) {
            wholeDistance += getDistanceOf(path.get(i - 1), path.get(i));
        }
        return wholeDistance;
    }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static Integer getWholeTime(List<String> path) {
        int wholeTime = 0;
        for (int i = 1; i < path.size(); i++) {
            wholeTime += getTimeOf(path.get(i - 1), path.get(i));
        }
        return wholeTime;
    }

    private static Integer getDistanceOf(String src, String dest) {
        return getEdgeOf(src, dest).getDistance();
    }

    private static Integer getTimeOf(String src, String dest) {
        return getEdgeOf(src, dest).getTime();
    }

    private static Edge getEdgeOf(String src, String dest) {
        return edges.stream().filter(edge -> edge.isEdgeOf(src, dest))
                .findFirst().orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_EDGE));
    }
}
