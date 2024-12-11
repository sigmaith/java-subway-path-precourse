package subway.view;

import java.util.Scanner;
import subway.controller.dto.SourceDestination;
import subway.exception.CustomException;
import subway.exception.ErrorMessage;

public class InputView {
    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public String getFunctionInMain() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료\n"
                + "\n"
                + "## 원하는 기능을 선택하세요.");
        return validateMainFunction(sc.next().trim());
    }

    private String validateMainFunction(String input) {
        if (!input.equals("1") && !input.equals("Q")) {
            throw CustomException.from(ErrorMessage.INVALID_MAIN_FUNCTION_INPUT);
        }
        return input;
    }

    public String getSearchCriteria() {
        System.out.println("\n## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간 \n"
                + "B. 돌아가기\n\n"
                + "## 원하는 기능을 선택하세요.");
        return validateSearchCriteria(sc.next().trim());
    }

    private String validateSearchCriteria(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("B")) {
            throw CustomException.from(ErrorMessage.INVALID_SEARCH_OPTION_INPUT);
        }
        return input;
    }

    public SourceDestination getStationInfo() {
        System.out.println("\n## 출발역을 입력하세요.");
        String source = sc.next().trim();
        System.out.println("\n## 도착역을 입력하세요.");
        String destination = sc.next().trim();
        return new SourceDestination(source, destination);
    }
}
