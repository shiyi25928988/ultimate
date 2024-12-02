package yi.shi.pages.responsive;

import static j2html.TagCreator.*;  
import java.util.Map;
import j2html.tags.specialized.NavTag;
import j2html.tags.specialized.LiTag;

public class ResponsiveNav {

    public static NavTag create(String logo, String title, Map<String, String> menu) {
        return nav()
            .with(
                div().withClass("nav-wrapper")
                    .with(
                        a().withHref("#").withClass("brand-logo").withText(logo),
                        // 移动端的菜单按钮
                        a().withHref("#").withClass("sidenav-trigger")
                            .attr("data-target", "mobile-nav")
                            .with(i().withClass("material-icons").withText("menu")),
                        // 桌面端的导航菜单
                        ul().withClass("right hide-on-med-and-down")
                            .with(
                                createMenuItems(menu)
                            )
                    )
            );
    }

    private static LiTag[] createMenuItems(Map<String, String> menu) {
        return menu.entrySet().stream()
            .map(entry -> createMenuItem(entry.getKey(), entry.getValue()))
            .toArray(LiTag[]::new);
    }

    private static LiTag createMenuItem(String menu, String href) {
        return li().with(a().withHref(href).withText(menu));
    }
}
