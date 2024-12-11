package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import subway.controller.SearchController;
import subway.view.InputView;
import subway.view.OutputView;

class LineRepositoryTest {
    @Test
    void 세개_호선_기능_테스트() {
        LineRepository.deleteAll();
        new SearchController(new InputView(new Scanner(System.in)), new OutputView());
        assertThat(LineRepository.lines().size()).isEqualTo(3);
    }
}