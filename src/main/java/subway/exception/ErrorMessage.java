package subway.exception;

public enum ErrorMessage {
    INVALID_STATION_NAME("유효하지 않은 역 이름입니다. 다시 입력해 주세요."),
    INVALID_MAIN_FUNCTION_INPUT("메인 화면의 기능 선택은 1 또는 Q로 입력해주세요."),
    INVALID_SEARCH_OPTION_INPUT("1, 2, B 로 입력해주세요"),
    SAME_SOURCE_DESTINATION("출발역과 도착역이 동일합니다."),
    UNABLE_TO_ARRIVE("출발역과 도착역이 연결되어 있지 않습니다"),
    INVALID_EDGE("해당 출발역과 도착역을 가진 간선이 없습니다");
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
