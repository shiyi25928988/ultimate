package yi.shi.pages.theme;

public enum DeepOrange implements Color{
    DEFAULT("deep-orange", "#ff9800"),
    LIGHTEN_1("deep-orange lighten-1", "#ffa726"),
    LIGHTEN_2("deep-orange lighten-2", "#ffb74d"),
    LIGHTEN_3("deep-orange lighten-3", "#ffcc80"),
    LIGHTEN_4("deep-orange lighten-4", "#ffe0b2"),
    LIGHTEN_5("deep-orange lighten-5", "#fff3e0"),
    DARKEN_1("deep-orange darken-1", "#f57c00"),
    DARKEN_2("deep-orange darken-2", "#ef6c00"),
    DARKEN_3("deep-orange darken-3", "#e65100"),
    DARKEN_4("deep-orange darken-4", "#dd2c00"),
    ACCENT_1("deep-orange accent-1", "#ffd180"),
    ACCENT_2("deep-orange accent-2", "#ffab40"),
    ACCENT_3("deep-orange accent-3", "#ff9100"),
    ACCENT_4("deep-orange accent-4", "#ff6d00")
    ;

    private String name;
    private String value;

    DeepOrange(String name, String value) {
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
