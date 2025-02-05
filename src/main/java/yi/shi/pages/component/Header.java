package yi.shi.pages.component;

import com.google.common.base.Strings;
import j2html.tags.DomContent;
import j2html.tags.specialized.HeaderTag;
import yi.shi.pages.theme.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static j2html.TagCreator.*;

public class Header {
    public static HeaderTag createHeader() {
        return generateHeader(Menu.getMenu(), null);
    }

    public static HeaderTag createHeader(Color color) {
        return generateHeader(Menu.getMenu(), color.getName());
    }

    public static HeaderTag createHeader(String color) {
        return generateHeader(Menu.getMenu(), color);
    }

    private static HeaderTag generateHeader(Map<String, String> menuItems, String color) {
        return header().with(
                nav().withClass("nav-extended "+ (Strings.isNullOrEmpty(color) ? "" : color)).with(
                        div().withClass("nav-wrapper").with(
                                a().withClass("brand-logo").withHref("#"),
                                a().withClass("sidenav-trigger").withHref("#").withData("target", "side-nav").with(
                                        i().withClass("material-icons").withText("menu")
                                ),
                                ul().withClass("right hide-on-med-and-down").with(
                                        getMenuItems(menuItems)
                                )
                        )
                ),
                ul().withId("side-nav").withClass("sidenav").with(
                        li().with(
                                div().withClass("user-view").with(
                                        div().withClass("background").with(
                                                img().withSrc("/img/pic?filename=office.jpg")
                                        ),
                                        a().withHref("#user").with(
                                                img().withSrc("/img/pic?filename=yuna.jpg").withClass("circle")
                                        ),
                                        a().withHref("#name").with(
                                                span().with().withClass("white-text name").withText("Yuna Nijmegen")
                                        ),
                                        a().withHref("#email").with(
                                                span().with().withClass("white-text email").withText("XwJWz@example.com")
                                        )
                                )
                        ).with(
                                getMenuItems(menuItems)
                        )
                ).with(
                        script().withSrc("/js/SideNav.js")
                )
        );
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
