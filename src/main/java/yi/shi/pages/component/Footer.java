package yi.shi.pages.component;

import j2html.tags.specialized.FooterTag;
import yi.shi.pages.theme.Color;

import java.util.Objects;

import static j2html.TagCreator.*;

public class Footer {

    public static FooterTag createFooter() {
        return createFooter(null);
    }
    public static FooterTag createFooter(Color color) {
        return footer().withClass("page-footer "+ (Objects.isNull(color) ? "" : color.getName()) + "").with(
                div().withClass("container").with(
                        div().withClass("row").with(
                                div().withClass("col l6 s12").with(
//                                        h5("社交媒体").withClass("white-text")
//                                        ul().with(
//                                                li(a("Facebook").withHref("https://facebook.com").withTarget("_blank")),
//                                                li(a("Twitter").withHref("https://twitter.com").withTarget("_blank")),
//                                                li(a("Instagram").withHref("https://instagram.com").withTarget("_blank"))
//                                        )
                                )
                        )
                ),
                div().withClass("footer-copyright").with(
                        div().withClass("container").withText(
                                "© 2023 Ultimate Web. All rights reserved."
                        )
                )
        );
    }
}
