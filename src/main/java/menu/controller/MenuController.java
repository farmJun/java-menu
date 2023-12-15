package menu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.Name;
import menu.domain.Names;
import menu.domain.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    public void run() {
        printStartRecommendation();
        Names names = readNames();
        Coaches coaches = getCoaches(names);
        List<Category> categories = recommend(coaches);
        printResult(categories, coaches);
    }

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
        while (true) {
            try {
                List<Menu> menus = InputView.readInedibleMenus(name).stream()
                    .map(Menu::find)
                    .collect(Collectors.toList());
                return new Menus(menus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private List<Category> recommend(Coaches coaches) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = recommendCategory(categories);
            recommendMenu(coaches, category);
        }
        return categories;
    }

    private Category recommendCategory(List<Category> categories) {
        Category category = Recommendation.recommendCategory(categories);
        return category;
    }

    private void recommendMenu(Coaches coaches, Category category) {
        Recommendation.recommendMenu(coaches,category);
    }

    private void printResult(List<Category> categories, Coaches coaches) {
        OutputView.printResult();
        OutputView.printDays();
        OutputView.printCategories(categories);
        OutputView.printCoachAndMenus(coaches.getCoaches());
        OutputView.printEndRecommendation();
    }
}
