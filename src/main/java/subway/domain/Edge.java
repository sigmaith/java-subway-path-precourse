package subway.domain;

public class Edge {
    private final Integer distance;
    private final Integer time;
    private final Station s1;
    private final Station s2;

    public static Edge of(Integer distance, Integer time, Station s1, Station s2) {
        return new Edge(distance, time, s1, s2);
    }

    private Edge(Integer distance, Integer time, Station s1, Station s2) {
        this.distance = distance;
        this.time = time;
        this.s1 = s1;
        this.s2 = s2;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getTime() {
        return time;
    }

    public boolean isEdgeOf(String src, String dest) {
        if (s1.getName().equals(src) && s2.getName().equals(dest)) {
            return true;
        }
        if (s2.getName().equals(src) && s1.getName().equals(dest)) {
            return true;
        }
        return false;
    }
}
