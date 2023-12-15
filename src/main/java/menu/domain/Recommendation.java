package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Recommendation {

    private static final int MINIMUM_CATEGORY_CODE = 1;
    private static final int MAXIMUM_CATEGORY_CODE = 5;
    private static final int FIRST = 0;

    private Recommendation() {

    }

    public static Category recommendCategory() {
        Category category = Category.findByCode(generateRandomCode());
        return category;
    }

    public static Menu recommendMenu(Category category) {
        List<String> menuNames = category.getMenuNames();
        String menu = Randoms.shuffle(menuNames).get(FIRST);
        return Menu.find(menu);
    }

    private static int generateRandomCode() {
        return Randoms.pickNumberInRange(MINIMUM_CATEGORY_CODE, MAXIMUM_CATEGORY_CODE);
    }
}
