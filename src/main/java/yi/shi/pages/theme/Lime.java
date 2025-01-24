package yi.shi.pages.theme;

public enum Lime implements Color{
    DEFAULT("lime", "#cddc39"),
    LIGHTEN_1("lime lighten-1", "#d4e157"),
    LIGHTEN_2("lime lighten-2", "#eeff41"),
    LIGHTEN_3("lime lighten-3", "#c6ff00"),
    LIGHTEN_4("lime lighten-4", "#aeea00"),
    LIGHTEN_5("lime lighten-5", "#fff9c4"),
    DARKEN_1("lime darken-1", "#c0ca33"),
    DARKEN_2("lime darken-2", "#afb42b"),
    DARKEN_3("lime darken-3", "#9e9d24"),
    DARKEN_4("lime darken-4", "#827717"),
    ACCENT_1("lime accent-1", "#f4ff81"),
    ACCENT_2("lime accent-2", "#eeff41"),
    ACCENT_3("lime accent-3", "#c6ff00"),
    ACCENT_4("lime accent-4", "#aeea00")
    ;

    private String name;
    private String value;

    Lime(String name, String value){
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
