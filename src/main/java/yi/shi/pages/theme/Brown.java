package yi.shi.pages.theme;

public enum Brown implements Color{
    DEFAULT("brown", "#795548"),
    LIGHTEN_1("brown lighten-1", "#a0522d"),
    LIGHTEN_2("brown lighten-2", "#a52a2a"),
    LIGHTEN_3("brown lighten-3", "#8b4513"),
    LIGHTEN_4("brown lighten-4", "#8b4513"),
    LIGHTEN_5("brown lighten-5", "#f5f5f5"),
    DARKEN_1("brown darken-1", "#7b3f00"),
    DARKEN_2("brown darken-2", "#6d4c00"),
    DARKEN_3("brown darken-3", "#5d4037"),
    DARKEN_4("brown darken-4", "#4e342e")
    ;

    private String name;
    private String value;

    Brown(String name, String value){
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
