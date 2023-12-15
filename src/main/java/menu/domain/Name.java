package menu.domain;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;
    private static final String LESS_THAN_MINIMUM_NAME_LENGTH = "[ERROR] 최소 길이 미만의 이름입니다.";
    private static final String OVER_MAXIMUM_NAME_LENGTH = "[ERROR] 최대 길이 초과의 이름입니다.";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_NAME_LENGTH);
        }

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_MAXIMUM_NAME_LENGTH);
        }
    }
}
