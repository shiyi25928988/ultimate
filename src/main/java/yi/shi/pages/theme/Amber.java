package yi.shi.pages.theme;

public enum Amber implements Color{
    DEFAULT("amber", "#ffc107"),
    LIGHTEN_1("amber lighten-1", "#ffd740"),
    LIGHTEN_2("amber lighten-2", "#ffe57f"),
    LIGHTEN_3("amber lighten-3", "#fff9c4"),
    LIGHTEN_4("amber lighten-4", "#fff59d"),
    LIGHTEN_5("amber lighten-5", "#fff8e1"),
    DARKEN_1("amber darken-1","#ffb300"),
    DARKEN_2("amber darken-2","#ffa000"),
    DARKEN_3("amber darken-3","#ff8f00"),
    DARKEN_4("amber darken-4","#ff6f00"),
    ACCENT_1("amber accent-1","#ffe57f"),
    ACCENT_2("amber accent-2","#ffd740"),
    ACCENT_3("amber accent-3","#ffc400"),
    ACCENT_4("amber accent-4","#ffab00")
    ;

    private String name;
    private String value;

    Amber(String name, String value){
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
