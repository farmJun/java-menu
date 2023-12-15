package menu.domain;

public class Name {

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 이름 길이");
        }
    }
}
