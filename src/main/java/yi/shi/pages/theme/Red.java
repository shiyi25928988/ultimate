package yi.shi.pages.theme;

public enum Red implements Color{
    DEFAULT("red", "#f44336"),
    LIGHTEN_1("red lighten-1", "#ef5350"),
    LIGHTEN_2("red lighten-2", "#e57373"),
    LIGHTEN_3("red lighten-3", "#ef9a9a"),
    LIGHTEN_4("red lighten-4", "#ffcdd2"),
    LIGHTEN_5("red lighten-5", "#ffebee"),
    DARKEN_1("red darken-1", "#e53935"),
    DARKEN_2("red darken-2", "#d32f2f"),
    DARKEN_3("red darken-3", "#c62828"),
    DARKEN_4("red darken-4", "#b71c1c"),
    ACCENT_1("red accent-1", "#ff8a80"),
    ACCENT_2("red accent-2", "#ff5252"),
    ACCENT_3("red accent-3", "#ff1744"),
    ACCENT_4("red accent-4", "#d50000");

    private String name;
    private String value;

    Red(String name, String value) {
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
