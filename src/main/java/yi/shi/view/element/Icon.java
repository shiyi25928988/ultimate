package yi.shi.view.element;

import j2html.tags.specialized.ITag;

import static j2html.TagCreator.*;

public class Icon {

    private static final String MATERIAL_ICON = "material-icons ";

    public static final String PREFIX = "prefix ";

    public enum Size {
        LARGE("large "),
        SMALL("small "),
        MEDIUM("medium "),
        TINY("tiny ");

        private String size;
        Size(String size){
            this.size = size;
        }
        public String getSize() {
            return size;
        }
    }
    public enum Direction {
        LEFT("left "),
        RIGHT("right ");

        private String direction;
        Direction(String direction){
            this.direction = direction;
        }
        public String getDirection() {
            return direction;
        }
    }

    public static ITag icon(String icon){
        return i().withClass(MATERIAL_ICON).withText(icon);
    }

    public static ITag prefixIcon(String icon){
        return i().withClass(MATERIAL_ICON + PREFIX).withText(icon);
    }

    public static ITag icon(String icon, Size size){
        return i().withClass(MATERIAL_ICON + size.getSize()).withText(icon);
    }

    public static ITag icon(String icon, Direction direction){
        return i().withClass(MATERIAL_ICON + direction.getDirection()).withText(icon);
    }

    public static ITag icon(String icon, Size size, Direction direction){
        return i().withClass(MATERIAL_ICON + size + direction).withText(icon);
    }

}
