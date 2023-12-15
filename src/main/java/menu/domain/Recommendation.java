package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Recommendation {

    private Recommendation() {

    }

    public static Category recommendCategory() {
        Category category = Category.findByCode(Randoms.pickNumberInRange(1, 5));
        return category;
    }
}
