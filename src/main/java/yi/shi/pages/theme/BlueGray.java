package yi.shi.pages.theme;

public enum BlueGray implements Color{
    DEFAULT("blue-gray", "#607d8b"),
    LIGHTEN_1("blue-gray lighten-1", "#546e7a"),
    LIGHTEN_2("blue-gray lighten-2", "#455a64"),
    LIGHTEN_3("blue-gray lighten-3", "#37474f"),
    LIGHTEN_4("blue-gray lighten-4", "#263238"),
    LIGHTEN_5("blue-gray lighten-5", "#cfd8dc"),
    DARKEN_1("blue-gray darken-1", "#455a64"),
    DARKEN_2("blue-gray darken-2", "#37474f"),
    DARKEN_3("blue-gray darken-3", "#263238"),
    DARKEN_4("blue-gray darken-4", "#cfd8dc")
    ;

    private String name;
    private String value;

    BlueGray(String name, String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
