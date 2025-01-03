package yi.shi.pages.element;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;
import j2html.tags.Tag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.NavTag;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public class Header {
    public static HeaderTag createHeader() {
        return generateHeader(Menu.getMenu());
    }

    private static HeaderTag generateHeader(Map<String, String> menuItems) {
        return header(nav(
                div().withClass("nav-wrapper").with(
                        // Logo
                        a("Logo").withClass("brand-logo").withHref("/"),

                        // 汉堡菜单按钮
                        a().withClass("sidenav-trigger").withHref("#")
                                .withData("target", "mobile-menu")
                                .with(i().withClass("material-icons").withText("menu")),

                        // 桌面端菜单
                        ul().withClass("right hide-on-med-and-down")
                                .with(getMenuItems(menuItems)),

                        // 移动端侧边菜单
                        ul().withClass("sidenav").withId("mobile-menu")
                                .with(getMobileMenuItems(menuItems))
                )
        ).withClass("navbar dark lighten-2")).withClass("top-bar");

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

    private static DomContent[] getMobileMenuItems(Map<String, String> menuItems) {
        List<DomContent> items = new ArrayList<>();
        if (menuItems != null) {
            // 添加头部用户信息区域
            items.add(
                    li(
                            div().withClass("user-view")
                                    .with(
                                            div().withClass("background blue lighten-2"),
                                            a(img().withClass("circle").withSrc("/images/user-avatar.jpg")),
                                            a(span().withClass("white-text name").withText("用户名")),
                                            a(span().withClass("white-text email").withText("user@example.com"))
                                    )
                    )
            );

            // 添加分割线
            items.add(li(div().withClass("divider")));

            // 添加菜单项
            for (Map.Entry<String, String> entry : menuItems.entrySet()) {
                items.add(
                        li(
                                a(entry.getKey()).withHref(entry.getValue())
                                        .withClass("waves-effect")
                        )
                );
            }
        }
        return items.toArray(new DomContent[0]);
    }

}
