package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.Name;
import menu.domain.Names;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private void printStartRecommendation() {
        OutputView.printStartRecommendation();
    }

    private Names readNames() {
        while (true) {
            try {
                List<Name> names = InputView.readNames().stream()
                    .map(Name::new)
                    .collect(Collectors.toList());
                return new Names(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Coaches getCoaches(Names names) {
        List<Coach> coaches = new ArrayList<>();

        for (Name name : names.getNames()) {
            Menus inedibleMenus = readInedibleMenus(name);
            Coach coach = new Coach(name, inedibleMenus);
            coaches.add(coach);
        }
        return new Coaches(coaches);
    }

    private Menus readInedibleMenus(Name name) {
        List<Menu> menus = InputView.readInedibleMenus(name).stream()
            .map(Menu::find)
            .collect(Collectors.toList());
        return new Menus(menus);
    }

}
