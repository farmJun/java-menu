package menu.domain;

import java.util.List;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        vaildate(names);
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    private void vaildate(List<Name> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 너무 많은 코치");
        }

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복 이름");
        }
    }
}
