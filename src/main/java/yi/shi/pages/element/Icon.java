package yi.shi.pages.element;

import j2html.tags.specialized.ITag;

import static j2html.TagCreator.*;

public class Icon {

    public static String LARGE = "large";
    public static String SMALL = "small";
    public static String MEDIUM = "medium";
    public static String TINY = "tiny";
    public static String PREFIX = "prefix";

    public static ITag icon(String icon){
        return i().withClass("material-icons").withText(icon);
    }

    public static ITag icon(String icon, String size){
        return i().withClass("material-icons " + size).withText(icon);
    }




}
