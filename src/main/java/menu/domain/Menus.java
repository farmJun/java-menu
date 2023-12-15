package menu.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private static final String REPETITION_MENUS = "[ERROR] 메뉴가 중복되었습니다.";
    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        vaildate(menus);
        this.menus = menus;
    }

    public boolean has(Menu menu) {
        return menus.contains(menu);
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public List<String> getMenusNames() {
        return menus.stream()
            .map(Menu::getName)
            .collect(Collectors.toList());
    }

    public int size() {
        return menus.size();
    }

    private void vaildate(List<Menu> menus) {
        if (menus.size() != menus.stream().distinct().count()) {
            throw new IllegalArgumentException(REPETITION_MENUS);
        }
    }
}
