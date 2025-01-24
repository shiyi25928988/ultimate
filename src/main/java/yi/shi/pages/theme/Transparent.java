package yi.shi.pages.theme;

public enum Transparent implements Color{
    DEFAULT("transparent", "#00000000");

    private String name;
    private String value;

    Transparent(String name, String value){
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
