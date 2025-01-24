package yi.shi.pages.theme;

public enum Pink implements Color{

    DEFAULT("pink", "#e91e63"),
    LIGHTEN_1("pink lighten-1", "#ec407a"),
    LIGHTEN_2("pink lighten-2", "#f06292"),
    LIGHTEN_3("pink lighten-3", "#f48fb1"),
    LIGHTEN_4("pink lighten-4", "#f8bbd0"),
    LIGHTEN_5("pink lighten-5", "#fce4ec"),
    DARKEN_1("pink darken-1", "#d81b60"),
    DARKEN_2("pink darken-2", "#c2185b"),
    DARKEN_3("pink darken-3", "#ad1457"),
    DARKEN_4("pink darken-4", "#880e4f"),
    ACCENT_1("pink accent-1", "#ff80ab"),
    ACCENT_2("pink accent-2", "#ff4081"),
    ACCENT_3("pink accent-3", "#f50057"),
    ACCENT_4("pink accent-4", "#c51162");

    private String name;
    private String value;

    Pink(String name, String value) {
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
