package menu.domain;

import java.util.List;

public class Names {

    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String LESS_THAN_MINIMUM_COACH = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다.";
    private static final String OVER_MAXIMUM_COACH = "[ERROR] 코치는 최대 5명까지 입력 가능합니다.";
    private static final String REPETITION_NAME = "[ERROR] 코치 이름이 중복되서는 안됩니다.";

    private final List<Name> names;

    public Names(List<Name> names) {
        vaildate(names);
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    private void vaildate(List<Name> names) {
        if (names.size() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_COACH);
        }

        if (names.size() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_MAXIMUM_COACH);
        }

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(REPETITION_NAME);
        }
    }
}
