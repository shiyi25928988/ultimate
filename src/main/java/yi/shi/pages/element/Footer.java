package yi.shi.pages.element;

import j2html.tags.specialized.FooterTag;

import static j2html.TagCreator.*;

public class Footer {
    public static FooterTag createFooter() {
        return footer().withClass("page-footer").with(
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
