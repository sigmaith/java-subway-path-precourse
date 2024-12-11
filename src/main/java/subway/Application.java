package subway;

import java.util.Scanner;
import subway.controller.SearchController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SearchController searchController = new SearchController(new InputView(scanner), new OutputView());
        searchController.run();
    }
}
