package yi.shi.pages.theme;

public enum Green implements Color{
    DEFAULT("green", "#4caf50"),
    LIGHTEN_1("green lighten-1", "#5cb860"),
    LIGHTEN_2("green lighten-2", "#66bb6a"),
    LIGHTEN_3("green lighten-3", "#76ff03"),
    LIGHTEN_4("green lighten-4", "#ccff90"),
    LIGHTEN_5("green lighten-5", "#e8f5e9"),
    DARKEN_1("green darken-1", "#43a047"),
    DARKEN_2("green darken-2", "#388e3c"),
    DARKEN_3("green darken-3", "#2e7d32"),
    DARKEN_4("green darken-4", "#1b5e20"),
    ACCENT_1("green accent-1", "#b9f6ca"),
    ACCENT_2("green accent-2", "#69f0ae"),
    ACCENT_3("green accent-3", "#00e676"),
    ACCENT_4("green accent-4", "#00c853");

    private String name;
    private String value;

    Green(String name, String value) {
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
