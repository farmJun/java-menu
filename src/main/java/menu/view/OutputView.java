package menu.view;

import java.util.List;
import java.util.StringJoiner;
import menu.domain.Category;
import menu.domain.Day;

public class OutputView {

    private OutputView() {

    }

    public static void printStartRecommendation() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printDays() {
        StringJoiner headerJoiner = new StringJoiner(" | ");
        headerJoiner.add("구분");
        for (int i = 0; i < 5; i++) {
            Day day = Day.find(i);
            headerJoiner.add(day.getDayName());
        }
        System.out.println("[ " + headerJoiner + " ]");
    }

    public static void printCategories(List<Category> categories) {
        StringJoiner categoryJoiner = new StringJoiner(" | ");
        categoryJoiner.add("카테고리");
        for (Category category : categories) {
            categoryJoiner.add(category.getName());
        }
        System.out.println("[ " + categoryJoiner + " ]");
    }

}
