package yi.shi.pages.element;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import j2html.tags.Tag;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public class Header {
    public static ContainerTag createHeader() {
        Map<String, String> menuItems = new LinkedHashMap<>();
        menuItems.put("Home", "/");
        menuItems.put("Upload", "/page/uploadpage");
        menuItems.put("About", "/about");
        menuItems.put("Contact", "/contact");
        return generateHeader(menuItems);
    }

    public static ContainerTag generateHeader(Map<String, String> menuItems) {
        return nav(
                div(
                        a("Logo").withClass("brand-logo").withHref("#"),
                        ul(
                                getMenuItems(menuItems)
                        ).withId("nav-mobile").withClass("nav-wrapper")
                )
        ).withClass("navbar blue lighten-2");
    }

    private static DomContent[] getMenuItems(Map<String, String> menuItems) {
            List<DomContent> items = new ArrayList<>();
            if (menuItems != null) {
                    for (Map.Entry<String, String> entry : menuItems.entrySet()) {
                            items.add(li(a(entry.getKey()).withHref(entry.getValue())).withClass("right hide-on-med-and-down"));
                    }
            }
            return items.toArray(new DomContent[0]);
    }

}
