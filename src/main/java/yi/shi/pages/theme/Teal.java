package yi.shi.pages.theme;

public enum Teal implements Color{
    DEFAULT("teal", "#009688"),
    LIGHTEN_1("teal lighten-1", "#00bfa5"),
    LIGHTEN_2("teal lighten-2", "#00bcd4"),
    LIGHTEN_3("teal lighten-3", "#26c6da"),
    LIGHTEN_4("teal lighten-4", "#4dd0e1"),
    LIGHTEN_5("teal lighten-5", "#80deea"),
    DARKEN_1("tealdarken-1", "#00897b"),
    DARKEN_2("teal darken-2", "#00796b"),
    DARKEN_3("teal darken-3", "#00695c"),
    DARKEN_4("teal darken-4", "#004d40"),
    ACCENT_1("teal accent-1", "#a7ffeb"),
    ACCENT_2("teal accent-2", "#64ffda"),
    ACCENT_3("teal accent-3", "#1de9b6"),
    ACCENT_4("teal accent-4", "#00bfa5")
    ;

    private String name;
    private String value;

    Teal(String name, String value) {
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
