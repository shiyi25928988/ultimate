package yi.shi.pages.component;

import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public class Card {

    public static DivTag imageCard(String title, String content, String imageUrl) {
        return div().withClass("row").with(
                div().withClass("col s12 m7").with(
                        div().withClass("card").with(
                                div().withClass("card-image").with(
                                        img().withSrc(imageUrl).withAlt(title),
                                        span().withClass("card-title").withText(title)
                                ),
                                div().withClass("card-content").with(
                                        p().withText(content)
                                )
                        )
                )
        );
    }


    public static DivTag darkCard(String title, String content) {
        return div().withClass("row").with(
                div().withClass("col s12 m6 l4").with(
                        div().withClass("card blue-grey darken-1").with(
                                div().withClass("card-content white-text").with(
                                        span().withClass("card-title").withText(title),
                                        p().withText(content)
                                )
                        )
                )
        );
    }

    public static DivTag lightCard(String title, String content) {
        return div().withClass("row").with(
                div().withClass("col s12 m6 l4").with(
                        div().withClass("card").with(
                                div().withClass("card-content").with(
                                        span().withClass("card-title").withText(title),
                                        p().withText(content)
                                )
                        )
                )
        );
    }
}
