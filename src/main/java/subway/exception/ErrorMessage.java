package subway.exception;

public enum ErrorMessage {
    INVALID_STATION_NAME("유효하지 않은 역 이름입니다. 다시 입력해 주세요.");
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
