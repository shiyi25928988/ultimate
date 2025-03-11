package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public class GeneralCard {

    private static DivTag createGeneralCard(String title, String content, String imageUrl, String linkUrl) {
        return div().with(
                div().withClass("col s12 m6 l4").with(
                        a().withHref(linkUrl).with(
                                div().withClass("card hoverable medium").with(
                                        div().withClass("card-image").with(
                                                img().withSrc(imageUrl).withAlt(title),
                                                span().withClass("card-title").withText(title)
                                        ),
                                        div().withClass("card-content").with(
                                                p().withText(content).withStyle("truncate")
                                        )
                                )
                        )
                )
        );
    }
}
