package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Recommendation {

    private static final int MINIMUM_CATEGORY_CODE = 1;
    private static final int MAXIMUM_CATEGORY_CODE = 5;
    private static final int FIRST = 0;

    private Recommendation() {

    }

    public static Category recommendCategory(List<Category> categories) {
        while (true) {
            Category category = Category.findByCode(generateRandomCode());

            int freq = Collections.frequency(categories, category);

            if (freq < 2) {
                categories.add(category);
                return category;
            }
        }
    }

    public static void recommendMenu(Coaches coaches, Category category) {
        for (Coach coach : coaches.getCoaches()) {
            recommendMenu(category, coach);
        }
    }

    private static void recommendMenu(Category category, Coach coach) {
        while (true) {
            List<String> menuNames = category.getMenuNames();
            String menuName = Randoms.shuffle(menuNames).get(FIRST);
            Menu menu = Menu.find(menuName);
            if (!coach.inedible(menu) && !coach.alreadyRecommended(menu)) {
                coach.recommend(menu);
                break;
            }
        }
    }

    private static int generateRandomCode() {
        return Randoms.pickNumberInRange(MINIMUM_CATEGORY_CODE, MAXIMUM_CATEGORY_CODE);
    }
}
