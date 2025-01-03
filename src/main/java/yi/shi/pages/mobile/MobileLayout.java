package yi.shi.pages.mobile;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class MobileLayout {
    public static ContainerTag create(String activeTab, ContainerTag content) {
        return div().withClass("mobile-layout")
                .with(
                        // 主要内容区域
                        main().withClass("page-content")
                                .with(content),

                        // 底部导航栏
                        nav().withClass("bottom-nav")
                                .with(
                                        a().withClass("nav-item" + (activeTab.equals("home") ? " active" : ""))
                                                .withHref("/")
                                                .with(
                                                        i().withClass("material-icons").withText("home"),
                                                        span().withText("首页")
                                                ),
                                        a().withClass("nav-item" + (activeTab.equals("explore") ? " active" : ""))
                                                .withHref("/explore")
                                                .with(
                                                        i().withClass("material-icons").withText("search"),
                                                        span().withText("发现")
                                                ),
                                        a().withClass("nav-item" + (activeTab.equals("create") ? " active" : ""))
                                                .withHref("/create")
                                                .with(
                                                        i().withClass("material-icons").withText("add_circle"),
                                                        span().withText("发布")
                                                ),
                                        a().withClass("nav-item" + (activeTab.equals("notifications") ? " active" : ""))
                                                .withHref("/notifications")
                                                .with(
                                                        i().withClass("material-icons").withText("notifications"),
                                                        span().withText("通知")
                                                ),
                                        a().withClass("nav-item" + (activeTab.equals("profile") ? " active" : ""))
                                                .withHref("/profile")
                                                .with(
                                                        i().withClass("material-icons").withText("person"),
                                                        span().withText("我的")
                                                )
                                )
                );
    }
}
