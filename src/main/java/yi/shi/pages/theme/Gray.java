package yi.shi.pages.theme;

public enum Gray implements Color{
    DEFAULT("gray", "#9e9e9e"),
    LIGHTEN_1("gray lighten-1", "#bdbdbd"),
    LIGHTEN_2("gray lighten-2", "#e0e0e0"),
    LIGHTEN_3("gray lighten-3", "#eeeeee"),
    LIGHTEN_4("gray lighten-4", "#f5f5f5"),
    LIGHTEN_5("gray lighten-5", "#fafafa"),
    DARKEN_1("gray darken-1", "#757575"),
    DARKEN_2("gray darken-2", "#616161"),
    DARKEN_3("gray darken-3", "#424242"),
    DARKEN_4("gray darken-4", "#212121")
    ;

    private String name;
    private String value;

    Gray(String name, String value){
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
