package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.domain.Name;

public class InputView {

    private static final String REGEX = ",";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_INEDIBLE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private InputView() {

    }

    public static List<String> readNames() {
        System.out.println(INPUT_COACH_NAME);
        String input = Console.readLine();
        return Arrays.asList(input.split(REGEX));
    }

    public static List<String> readInedibleMenus(Name name) {
        System.out.println(String.format(INPUT_INEDIBLE_MENU, name.getName()));
        String input = Console.readLine();
        return Arrays.asList(input.split(REGEX));
    }
}
