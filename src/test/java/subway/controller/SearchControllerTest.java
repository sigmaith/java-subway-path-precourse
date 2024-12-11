package subway.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import subway.controller.dto.SourceDestination;
import subway.exception.ErrorMessage;

class SearchControllerTest {
    @Test
    void 출발역과_도착역이_같을시_예외_테스트() {
        assertThatThrownBy(() -> new SourceDestination("출발역", "도착역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SAME_SOURCE_DESTINATION.getMessage());
    }
}