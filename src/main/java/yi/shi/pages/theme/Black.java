package yi.shi.pages.theme;

public enum Black implements Color{
    DEFAULT("black", "#000000");

    private String name;
    private String value;

    Black(String name, String value){
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
