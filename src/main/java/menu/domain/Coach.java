package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MAXIMUM_INEDIBLE_MENU_COUNT = 2;
    private static final String OVER_MAXIMUM_MENU_COUNT = "[ERROR] 코치가 못 먹는 음식은 최대 2개입니다.";

    private final Name name;
    private final Menus inedibleMenus;
    private final Menus recommendedMenus;


    public Coach(Name name, Menus inedibleMenus) {
        validate(inedibleMenus);
        this.name = name;
        this.inedibleMenus = inedibleMenus;
        this.recommendedMenus = new Menus(new ArrayList<>());
    }

    private void validate(Menus inedibleMenus) {
        if (inedibleMenus.size() > MAXIMUM_INEDIBLE_MENU_COUNT) {
            throw new IllegalArgumentException(OVER_MAXIMUM_MENU_COUNT);
        }
    }

    public boolean inedible(Menu menu) {
        return inedibleMenus.has(menu);
    }

    public boolean alreadyRecommended(Menu menu) {
        return recommendedMenus.has(menu);
    }

    public void recommend(Menu menu) {
        recommendedMenus.add(menu);
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus.getMenusNames();
    }

    public String getName() {
        return name.getName();
    }
}
