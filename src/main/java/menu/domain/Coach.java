package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

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
        if (inedibleMenus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 편식 쟁이");
        }
    }

    public boolean inedible(Menu menu) {
        return inedibleMenus.has(menu);
    }

}
