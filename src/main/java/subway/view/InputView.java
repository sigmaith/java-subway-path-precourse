package subway.view;

import java.util.Scanner;
import subway.controller.dto.SourceDestination;
import subway.exception.CustomException;
import subway.exception.ErrorMessage;

public class InputView {
    private final Scanner sc;
    private final String MAIN_DISPLAY_FUNCTION_INPUT_GUIDE = "## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.";
    private final String PATH_SEARCH_OR_RETURN_FUNCTION_INPUT_GUIDE = "\n## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간 \n"
            + "B. 돌아가기\n\n"
            + "## 원하는 기능을 선택하세요.";
    private final String SOURCE_STATION_INPUT_GUIDE = "\n## 출발역을 입력하세요.";
    private final String DESTINATION_STATION_INPUT_GUIDE = "\n## 도착역을 입력하세요.";

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String Q_OPTION = "Q";
    public static final String B_OPTION = "B";

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public String getFunctionInMain() {
        System.out.println(MAIN_DISPLAY_FUNCTION_INPUT_GUIDE);
        return validateMainFunction(sc.next().trim());
    }

    private String validateMainFunction(String input) {
        if (!input.equals(ONE) && !input.equals(Q_OPTION)) {
            throw CustomException.from(ErrorMessage.INVALID_MAIN_FUNCTION_INPUT);
        }
        return input;
    }

    public String getSearchCriteria() {
        System.out.println(PATH_SEARCH_OR_RETURN_FUNCTION_INPUT_GUIDE);
        return validateSearchCriteria(sc.next().trim());
    }

    private String validateSearchCriteria(String input) {
        if (!input.equals(ONE) && !input.equals(TWO) && !input.equals(B_OPTION)) {
            throw CustomException.from(ErrorMessage.INVALID_SEARCH_OPTION_INPUT);
        }
        return input;
    }

    public SourceDestination getStationInfo() {
        System.out.println(SOURCE_STATION_INPUT_GUIDE);
        String source = sc.next().trim();
        System.out.println(DESTINATION_STATION_INPUT_GUIDE);
        String destination = sc.next().trim();
        return new SourceDestination(source, destination);
    }
}
