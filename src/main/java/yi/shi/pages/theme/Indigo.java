package yi.shi.pages.theme;

public enum Indigo implements Color{
    DEFAULT("indigo", "#3f51b5"),
    LIGHTEN_1("indigo lighten-1", "#536dfe"),
    LIGHTEN_2("indigo lighten-2", "#5c6bc0"),
    LIGHTEN_3("indigo lighten-3", "#7986cb"),
    LIGHTEN_4("indigo lighten-4", "#9fa8da"),
    LIGHTEN_5("indigo lighten-5", "#c5cae9"),
    DARKEN_1("indigo darken-1", "#3949ab"),
    DARKEN_2("indigo darken-2", "#303f9f"),
    DARKEN_3("indigo darken-3", "#283593"),
    DARKEN_4("indigo darken-4", "#1a237e"),
    ACCENT_1("indigo accent-1", "#8c9eff"),
    ACCENT_2("indigo accent-2", "#536dfe"),
    ACCENT_3("indigo accent-3", "#3d5afe"),
    ACCENT_4("indigo accent-4", "#304ffe"),
    ;

    private String name;
    private String value;

    Indigo(String name, String value) {
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
