package yi.shi.pages.theme;

public enum Orange implements Color{
    DEFAULT("orange", "#ff9800"),
    LIGHTEN_1("orange lighten-1", "#ffb74d"),
    LIGHTEN_2("orange lighten-2", "#ffcc80"),
    LIGHTEN_3("orange lighten-3", "#ffe0b2"),
    LIGHTEN_4("orange lighten-4", "#fff3e0"),
    LIGHTEN_5("orange lighten-5", "#fff8e1"),
    DARKEN_1("orange darken-1", "#ffa726"),
    DARKEN_2("orange darken-2", "#ff7043"),
    DARKEN_3("orange darken-3", "#ff5722"),
    DARKEN_4("orange darken-4", "#f4511e"),
    ACCENT_1("orange accent-1", "#ffd180"),
    ACCENT_2("orange accent-2", "#ffab40"),
    ACCENT_3("orange accent-3", "#ff9100"),
    ACCENT_4("orange accent-4", "#ff6d00")
    ;

    private String name;
    private String value;

    Orange(String name, String value) {
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
