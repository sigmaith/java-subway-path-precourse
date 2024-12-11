package subway.controller.dto;

import subway.exception.CustomException;
import subway.exception.ErrorMessage;

public record SourceDestination(
        String source,
        String destination
) {
    public SourceDestination(String source, String destination) {
        areNotSame(source, destination);
        this.source = source;
        this.destination = destination;
    }

    private void areNotSame(String source, String destination) {
        if (source.equals(destination)) {
            throw CustomException.from(ErrorMessage.SAME_SOURCE_DESTINATION);
        }
    }
}
