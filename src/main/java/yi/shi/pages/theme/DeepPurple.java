package yi.shi.pages.theme;

public enum DeepPurple implements Color{

    DEFAULT("deep-purple", "#673ab7"),
    LIGHTEN_1("deep-purple lighten-1", "#7e57c2"),
    LIGHTEN_2("deep-purple lighten-2", "#9575cd"),
    LIGHTEN_3("deep-purple lighten-3", "#b39ddb"),
    LIGHTEN_4("deep-purple lighten-4", "#d1c4e9"),
    LIGHTEN_5("deep-purple lighten-5", "#e8eaf6"),
    DARKEN_1("deep-purple darken-1", "#5e35b1"),
    DARKEN_2("deep-purple darken-2", "#512da8"),
    DARKEN_3("deep-purple darken-3", "#4527a0"),
    DARKEN_4("deep-purple darken-4", "#311b92"),
    ACCENT_1("deep-purple accent-1", "#b388ff"),
    ACCENT_2("deep-purple accent-2", "#7c4dff"),
    ACCENT_3("deep-purple accent-3", "#651fff"),
    ACCENT_4("deep-purple accent-4", "#6200ea")
    ;

    private String name;
    private String value;

    private DeepPurple(String name, String value) {
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
