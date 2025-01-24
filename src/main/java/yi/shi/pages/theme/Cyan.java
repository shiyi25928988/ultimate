package yi.shi.pages.theme;

public enum Cyan implements Color {

    DEFAULT("cyan", "#00bcd4"),
    LIGHTEN_1("cyan lighten-1", "#26c6da"),
    LIGHTEN_2("cyan lighten-2", "#4dd0e1"),
    LIGHTEN_3("cyan lighten-3", "#80deea"),
    LIGHTEN_4("cyan lighten-4", "#b2ebf2"),
    LIGHTEN_5("cyan lighten-5", "#e0f7fa"),
    DARKEN_1("cyan darken-1", "#00acc1"),
    DARKEN_2("cyan darken-2", "#0097a7"),
    DARKEN_3("cyan darken-3", "#00838f"),
    DARKEN_4("cyan darken-4", "#006064"),
    ACCENT_1("cyan accent-1", "#84ffff"),
    ACCENT_2("cyan accent-2", "#18ffff"),
    ACCENT_3("cyan accent-3", "#00e5ff"),
    ACCENT_4("cyan accent-4", "#00b8d4")
    ;


    private String name;
    private String value;

    Cyan(String name, String value) {
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
