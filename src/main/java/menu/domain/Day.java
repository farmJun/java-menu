package menu.domain;

import java.util.Arrays;

public enum Day {
    MONDAY(0, "월요일"),
    TUESDAY(1, "화요일"),
    WEDNESDAY(2, "수요일"),
    THURSDAY(3, "목요일"),
    FRIDAY(4, "금요일"),
    NOTHING(-1, "없음");

    private final int dayNumber;
    private final String dayName;

    Day(int dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public static Day find(int number) {
        return Arrays.stream(values())
            .filter(day -> day.dayNumber == number)
            .findFirst()
            .orElse(NOTHING);
    }

    public String getDayName() {
        return dayName;
    }
}
