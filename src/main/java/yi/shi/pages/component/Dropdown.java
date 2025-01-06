package yi.shi.pages.component;

import j2html.tags.specialized.UlTag;

import static j2html.TagCreator.*;

public class Dropdown {

    public static UlTag getMenuImageDropdown() {
        return ul().withId("menuImageDropdown")
                .withClass("dropdown-content")
                .with(
                        li(a("image wall").withHref("/page/imageWall")),
                        li(a("upload image").withHref("/page/uploadpage"))
                );
    }

}
