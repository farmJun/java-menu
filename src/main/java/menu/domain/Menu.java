package menu.domain;

import java.util.Arrays;

public enum Menu {
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HIRICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAM_BAP("쌈밥"),
    DOJANG_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUK_BOKKEUM("제육볶음"),
    KANPOONGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPA_YUK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_DOUBU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    GOCHUJJAPCHAE("고추잡채"),
    PAD_THAI("팟타이"),
    KAO_PAD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    CHA_GIO("쌀국수"),
    TOM_YUM_KOONG("똠얌꿍"),
    BANH_MI("반미"),
    GOI_CUON("월남쌈"),
    BUN_THIT_NUONG("분짜"),
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    YAKI_UDON("뇨끼"),
    KISU("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니"),
    NOTHING("없음");

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public static Menu find(String name) {
        return Arrays.stream(Menu.values())
            .filter(menu -> menu.name.equals(name))
            .findFirst()
            .orElse(NOTHING);
    }

    public String getName() {
        return name;
    }
}
