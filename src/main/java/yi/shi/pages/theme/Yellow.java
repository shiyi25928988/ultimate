package yi.shi.pages.theme;

public enum Yellow implements Color{
    DEFAULT("yellow", "#ffeb3b"),
    LIGHTEN_1("yellow lighten-1", "#ffe082"),
    LIGHTEN_2("yellow lighten-2", "#ffd54f"),
    LIGHTEN_3("yellow lighten-3", "#ffca28"),
    LIGHTEN_4("yellow lighten-4", "#ffb300"),
    LIGHTEN_5("yellow lighten-5", "#fff3e0"),
    DARKEN_1("yellow darken-1", "#f9a825"),
    DARKEN_2("yellow darken-2", "#f57f17"),
    DARKEN_3("yellow darken-3", "#ef6c00"),
    DARKEN_4("yellow darken-4", "#e65100"),
    ACCENT_1("yellow accent-1", "#ffff8d"),
    ACCENT_2("yellow accent-2", "#ffff00"),
    ACCENT_3("yellow accent-3", "#ffea00"),
    ACCENT_4("yellow accent-4", "#ffd600")
    ;

    private String name;
    private String value;

    Yellow(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
}
