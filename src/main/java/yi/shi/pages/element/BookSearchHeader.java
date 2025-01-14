package yi.shi.pages.element;

import j2html.tags.DomContent;
import j2html.tags.specialized.HeaderTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public class BookSearchHeader {

    public static HeaderTag createHeader() {
        return generateHeader(Menu.getMenu());
    }

    private static HeaderTag generateHeader(Map<String, String> menuItems) {
        return header(
                nav(
                        div().withClass("nav-wrapper").with(
                                a("Logo").withClass("brand-logo").withHref("/"),
                                form().withClass("right").with(
                                        div().withClass("input-field").with(
                                                input().withType("search").withId("search").withPlaceholder("Search books...").attr("aria-label", "Search"),
                                                label().withFor("search").with(
                                                        i().withClass("material-icons").withText("search")
                                                ),
                                                i().withClass("material-icons").withText("search").attr("onclick", "searchBooks()")
                                        )
                                ),
                                ul().withClass("right hide-on-med-and-down").with(getMenuItems(menuItems))
                        )
                ).withClass("navbar dark lighten-2")
        ).withClass("top-bar");
    }

    private static DomContent[] getMenuItems(Map<String, String> menuItems) {
        List<DomContent> items = new ArrayList<>();
        if (menuItems != null) {
            for (Map.Entry<String, String> entry : menuItems.entrySet()) {
                items.add(
                        li(a(entry.getKey()).withHref(entry.getValue()))
                );
            }
        }
        return items.toArray(new DomContent[0]);
    }

}
