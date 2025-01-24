package yi.shi.pages.theme;

public enum White implements Color{
    DEFAULT("white", "#ffffff");

    private String name;
    private String value;

    White(String name, String value){
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
