package yi.shi.pages.responsive;

import static j2html.TagCreator.*;
import j2html.tags.specialized.DivTag;

public class ResponsiveCard {
    
    
    public static DivTag create(String title, String content) {
        return div().withClass("card")
            .with(
                div().withClass("card-content")
                    .with(
                        span().withClass("card-title").withText(title),
                        p().withText(content)
                    ),
                // 在移动端隐藏某些操作按钮
                div().withClass("card-action hide-on-small-only")
                    .with(
                        a().withHref("#").withText("操作1"),
                        a().withHref("#").withText("操作2")
                    )
            );
    }
}
