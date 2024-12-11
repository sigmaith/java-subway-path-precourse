package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import subway.controller.SearchController;
import subway.exception.ErrorMessage;
import subway.view.InputView;
import subway.view.OutputView;

class EdgeRepositoryTest {

    @Test
    void addEdge_기능_테스트() {
        EdgeRepository.deleteAll();
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        EdgeRepository.addEdge(
                Edge.of(1, 2, StationRepository.getStationBy("강남역"), StationRepository.getStationBy("매봉역")));
        assertThat(EdgeRepository.edges().size()).isEqualTo(8);
    }

    @Test
    void getWholeDistance_기능_테스트() {
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        List<String> path = Arrays.asList("교대역", "남부터미널역", "양재역", "양재시민의숲역");
        assertThat(EdgeRepository.getWholeDistance(path)).isEqualTo(19);
    }

    @Test
    void getWholeTime_기능_테스트() {
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        List<String> path = Arrays.asList("교대역", "남부터미널역", "양재역", "양재시민의숲역");
        assertThat(EdgeRepository.getWholeTime(path)).isEqualTo(10);
    }

    @Test
    void INVALID_EDGE_예외_테스트() {
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        List<String> path = Arrays.asList("없는역", "없는역1", "없는역2", "없는역3");
        assertThatThrownBy(() -> EdgeRepository.getWholeTime(path)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_EDGE.getMessage());
    }
}