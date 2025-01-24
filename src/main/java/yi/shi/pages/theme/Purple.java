package yi.shi.pages.theme;

public enum Purple implements Color{

    DEFAULT("purple", "#9c27b0"),
    LIGHTEN_1("purple lighten-1", "#ab47bc"),
    LIGHTEN_2("purple lighten-2", "#ba68c8"),
    LIGHTEN_3("purple lighten-3", "#ce93d8"),
    LIGHTEN_4("purple lighten-4", "#e1bee7"),
    LIGHTEN_5("purple lighten-5", "#f3e5f5"),
    DARKEN_1("purple darken-1", "#8e24aa"),
    DARKEN_2("purple darken-2", "#7b1fa2"),
    DARKEN_3("purple darken-3", "#6a1b9a"),
    DARKEN_4("purple darken-4", "#4a148c"),
    ACCENT_1("purple accent-1", "#ea80fc"),
    ACCENT_2("purple accent-2", "#b388ff"),
    ACCENT_3("purple accent-3", "#8c9eff"),
    ACCENT_4("purple accent-4", "#536dfe");

    private String name;
    private String value;
    Purple(String name, String value){
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
