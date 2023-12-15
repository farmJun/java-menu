package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.domain.Name;

public class InputView {

    private InputView() {

    }

    public static List<String> readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public static List<String> readInedibleMenus(Name name) {
        System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", name.getName()));
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }
}
