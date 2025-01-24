package yi.shi.pages.theme;

public enum Blue implements Color{
    DEFAULT("blue", "#2196f3"),
    LIGHTEN_1("blue lighten-1", "#29b6f6"),
    LIGHTEN_2("blue lighten-2", "#4fc3f7"),
    LIGHTEN_3("blue lighten-3", "#81d4fa"),
    LIGHTEN_4("blue lighten-4", "#b3e5fc"), // 默认
    LIGHTEN_5("blue lighten-5", "#e1f5fe"),
    DARKEN_1("blue darken-1", "#1e88e5"),
    DARKEN_2("blue darken-2", "#1976d2"),
    DARKEN_3("blue darken-3", "#1565c0"),
    DARKEN_4("blue darken-4", "#0d47a1"),
    ACCENT_1("blue accent-1", "#82b1ff"),
    ACCENT_2("blue accent-2", "#448aff"),
    ACCENT_3("blue accent-3", "#2979ff"),
    ACCENT_4("blue accent-4", "#2962ff");

    private String name;
    private String value;
    private Blue(String name, String value) {
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
