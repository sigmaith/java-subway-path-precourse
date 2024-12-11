package subway.controller;

import java.util.Arrays;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SearchController {
    private final InputView inputView;
    private final OutputView outputView;

    private final WeightedMultigraph<String, DefaultWeightedEdge> graphDist = new WeightedMultigraph(
            DefaultWeightedEdge.class); // 간선 (거리)
    private final WeightedMultigraph<String, DefaultWeightedEdge> graphTime = new WeightedMultigraph(
            DefaultWeightedEdge.class); // 간선 (시간)

    public SearchController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        configLines(); // 노선
        configStations(); // 정점
        configDistances(); // 거리
        configRequiredTimes(); // 시간
    }

    private void configLines() {
        List<String> lineNames = Arrays.asList("2호선", "3호선", "신분당선");
        lineNames.forEach(name -> LineRepository.addLine(new Line(name)));
    }

    private void configStations() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역");
        stationNames.forEach(name -> StationRepository.addStation(new Station(name)));
    }

    private void configDistances() {
        // 정점 추가
        StationRepository.stations().stream().map(Station::getName).forEach(graphDist::addVertex);
        // 거리 기반 엣지 추가
        graphDist.setEdgeWeight(graphDist.addEdge("교대역", "강남역"), 2);
        graphDist.setEdgeWeight(graphDist.addEdge("강남역", "역삼역"), 2);
        graphDist.setEdgeWeight(graphDist.addEdge("교대역", "남부터미널역"), 3);
        graphDist.setEdgeWeight(graphDist.addEdge("남부터미널역", "양재역"), 6);
        graphDist.setEdgeWeight(graphDist.addEdge("양재역", "매봉역"), 1);
        graphDist.setEdgeWeight(graphDist.addEdge("강남역", "양재역"), 2);
        graphDist.setEdgeWeight(graphDist.addEdge("양재역", "양재시민의숲역"), 10);
    }

    private void configRequiredTimes() {
        // 정점 추가
        StationRepository.stations().stream().map(Station::getName).forEach(graphTime::addVertex);
        // 시간 기반 엣지 추가
        graphTime.setEdgeWeight(graphTime.addEdge("교대역", "강남역"), 3);
        graphTime.setEdgeWeight(graphTime.addEdge("강남역", "역삼역"), 3);
        graphTime.setEdgeWeight(graphTime.addEdge("교대역", "남부터미널역"), 2);
        graphTime.setEdgeWeight(graphTime.addEdge("남부터미널역", "양재역"), 5);
        graphTime.setEdgeWeight(graphTime.addEdge("양재역", "매봉역"), 1);
        graphTime.setEdgeWeight(graphTime.addEdge("강남역", "양재역"), 8);
        graphTime.setEdgeWeight(graphTime.addEdge("양재역", "양재시민의숲역"), 3);
    }

    public void run() {

    }
}
