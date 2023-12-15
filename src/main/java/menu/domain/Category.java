package menu.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPANESE(1, "일식",
        Arrays.asList(Menu.GYUDON, Menu.UDON, Menu.MISOSHIRU, Menu.SUSHI, Menu.KATSUDON,
            Menu.ONIGIRI, Menu.HIRICE, Menu.RAMEN, Menu.OKONOMIYAKI)),
    KOREAN(2, "한식", Arrays.asList(Menu.GIMBAP, Menu.KIMCHI_STEW, Menu.SSAM_BAP, Menu.DOJANG_STEW,
        Menu.BIBIMBAP, Menu.KALGUKSU, Menu.BULGOGI, Menu.TTEOKBOKKI, Menu.JAEYUK_BOKKEUM)),
    CHINESE(3, "중식", Arrays.asList(Menu.KANPOONGI, Menu.STIR_FRIED_NOODLES, Menu.DONGPA_YUK,
        Menu.JAJANGMYEON, Menu.JJAMPPONG, Menu.MAPA_DOUBU, Menu.TANGSUYUK, Menu.TOMATO_EGG_STIR_FRY,
        Menu.GOCHUJJAPCHAE)),
    ASIAN(4, "아시안", Arrays.asList(Menu.PAD_THAI, Menu.KAO_PAD, Menu.NASI_GORENG,
        Menu.PINEAPPLE_FRIED_RICE, Menu.CHA_GIO, Menu.TOM_YUM_KOONG, Menu.BANH_MI, Menu.GOI_CUON,
        Menu.BUN_THIT_NUONG)),
    WESTERN(5, "양식", Arrays.asList(Menu.LASAGNA, Menu.GRATIN, Menu.YAKI_UDON, Menu.KISU,
        Menu.FRENCH_TOAST, Menu.BAGUETTE, Menu.SPAGHETTI, Menu.PIZZA, Menu.PANINI)),
    NOTHING(-1, "없음", Collections.emptyList());

    private final int code;
    private final String name;
    private final List<Menu> menuList;

    Category(int code, String name, List<Menu> menuList) {
        this.code = code;
        this.name = name;
        this.menuList = menuList;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenuNames() {
        return menuList.stream()
            .map(Menu::getName)
            .collect(Collectors.toList());
    }

    public static Category findByCode(int code) {
        return Arrays.stream(Category.values())
            .filter(category -> category.code == code)
            .findFirst()
            .orElse(NOTHING);
    }
}
