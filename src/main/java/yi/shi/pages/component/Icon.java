package yi.shi.pages.component;

import j2html.tags.specialized.ITag;

import static j2html.TagCreator.*;

public class Icon {

    public static String LARGE = "large";
    public static String SMALL = "small";
    public static String MEDIUM = "medium";
    public static String TINY = "tiny";
    public static String PREFIX = "prefix";
    public static String LEFT = "left";
    public static String RIGHT = "right";

    public static ITag icon(String icon){
        return i().withClass("material-icons").withText(icon);
    }

    public static ITag icon(String icon, String size){
        return i().withClass("material-icons " + size).withText(icon);
    }

    public static ITag icon(String icon, String size, String direction){
        return i().withClass("material-icons " + size + " " + direction).withText(icon);
    }

    public static ITag icon(String icon, String size, String direction, String prefix){
        return i().withClass("material-icons " + size + " " + direction + " " + prefix).withText(icon);
    }




}
