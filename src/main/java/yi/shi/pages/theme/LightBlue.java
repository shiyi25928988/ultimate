package yi.shi.pages.theme;

public enum LightBlue implements Color{
    DEFAULT("light-blue", "#03a9f4"),
    LIGHTEN_1("light-blue lighten-1", "#29b6f6"),
    LIGHTEN_2("light-blue lighten-2", "#4fc3f7"),
    LIGHTEN_3("light-blue lighten-3", "#81d4fa"),
    LIGHTEN_4("light-blue lighten-4", "#b3e5fc"),
    LIGHTEN_5("light-blue lighten-5", "#e1f5fe"),
    DARKEN_1("light-blue darken-1", "#039be5"),
    DARKEN_2("light-blue darken-2", "#0288d1"),
    DARKEN_3("light-blue darken-3", "#0277bd"),
    DARKEN_4("light-blue darken-4", "#01579b"),
    ACCENT_1("light-blue accent-1", "#80d8ff"),
    ACCENT_2("light-blue accent-2", "#40c4ff"),
    ACCENT_3("light-blue accent-3", "#00b0ff"),
    ACCENT_4("light-blue accent-4", "#0091ea")
    ;


    private String name;
    private String value;

    LightBlue(String name, String value) {
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
