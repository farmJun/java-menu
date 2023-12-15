package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Recommendation {

    private Recommendation() {

    }

    public static Category recommendCategory() {
        Category category = Category.findByCode(Randoms.pickNumberInRange(1, 5));
        return category;
    }

    public static Menu recommendMenu(Category category) {
        List<String> menuNames = category.getMenuNames();
        String menu = Randoms.shuffle(menuNames).get(0);
        return Menu.find(menu);
    }
}
