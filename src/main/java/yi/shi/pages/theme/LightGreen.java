package yi.shi.pages.theme;

public enum LightGreen implements Color{
    DEFAULT("light-green", "#8bc34a"),
    LIGHTEN_1("light-green lighten-1", "#9ccc65"),
    LIGHTEN_2("light-green lighten-2", "#aed581"),
    LIGHTEN_3("light-green lighten-3", "#c5e1a5"),
    LIGHTEN_4("light-green lighten-4", "#dce775"),
    LIGHTEN_5("light-green lighten-5", "#f0f4c3"),
    DARKEN_1("light-green darken-1", "#7cb342"),
    DARKEN_2("light-green darken-2", "#689f38"),
    DARKEN_3("light-green darken-3", "#558b2f"),
    DARKEN_4("light-green darken-4", "#33691e"),
    ACCENT_1("light-green accent-1", "#ccff90"),
    ACCENT_2("light-green accent-2", "#b2ff59"),
    ACCENT_3("light-green accent-3", "#76ff03"),
    ACCENT_4("light-green accent-4", "#64dd17")
    ;

    private String name;
    private String value;

    LightGreen(String name, String value) {
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
