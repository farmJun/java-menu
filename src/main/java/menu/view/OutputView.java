package menu.view;

import java.util.List;
import java.util.StringJoiner;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;

public class OutputView {

    private static final String START_MENU_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RESULT_OF_RECOMMENDATION = "메뉴 추천 결과입니다.";
    private static final String END_OF_RECOMMENDATION = "추천을 완료했습니다.";
    private static final String DELIMITER = " | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String CLASSIFICATION = "구분";
    private static final String CATEGORY = "카테고리";


    private OutputView() {

    }

    public static void printStartRecommendation() {
        System.out.println(START_MENU_RECOMMENDATION);
    }

    public static void printResult() {
        System.out.println(RESULT_OF_RECOMMENDATION);
    }

    public static void printDays() {
        StringJoiner headerJoiner = new StringJoiner(DELIMITER);
        headerJoiner.add(CLASSIFICATION);

        for (int i = 0; i < 5; i++) {
            Day day = Day.find(i);
            headerJoiner.add(day.getDayName());
        }

        System.out.println(PREFIX + headerJoiner + SUFFIX);
    }

    public static void printCategories(List<Category> categories) {
        StringJoiner categoryJoiner = new StringJoiner(DELIMITER);
        categoryJoiner.add(CATEGORY);

        for (Category category : categories) {
            categoryJoiner.add(category.getName());
        }

        System.out.println(PREFIX + categoryJoiner + SUFFIX);
    }

    public static void printCoachAndMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            StringJoiner coachJoiner = new StringJoiner(DELIMITER);
            coachJoiner.add(coach.getName());
            List<String> recommendedMenus = coach.getRecommendedMenus();

            for (String menu : recommendedMenus) {
                coachJoiner.add(menu);
            }

            System.out.println(PREFIX + coachJoiner + SUFFIX);
        }
    }

    public static void printEndRecommendation() {
        System.out.println(END_OF_RECOMMENDATION);
    }
}
