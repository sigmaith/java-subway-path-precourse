package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import subway.controller.SearchController;
import subway.exception.ErrorMessage;
import subway.view.InputView;
import subway.view.OutputView;

class StationRepositoryTest {
    @Test
    void 일곱개_역_기능_테스트() {
        StationRepository.deleteAll();
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        assertThat(StationRepository.stations().size()).isEqualTo(7);
    }

    @Test
    void 없는_역_예외테스트() {
        StationRepository.deleteAll();
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        assertThatThrownBy(() -> StationRepository.getStationBy("없는역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_STATION_NAME.getMessage());
    }
}