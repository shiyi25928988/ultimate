package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;
import yi.shi.db.model.Books;

import java.util.List;

import static j2html.TagCreator.*;

public class GeneralCard {

    public static DivTag createCardsDivTag(List<CardData> cardDataList) {
        DivTag[] divTags = new DivTag[cardDataList.size()];
        cardDataList.forEach(card -> divTags[cardDataList.indexOf(card)] = createLargeCard(card));
        return div().with(divTags);
    }

    public static DivTag createLargeCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), "large");
    }

    public static DivTag createLargeCard(String title, String content, String imageUrl, String linkUrl) {
        return createCard(title, content, imageUrl, linkUrl, "large");
    }

    public static DivTag createSmallCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), "small");
    }

    public static DivTag createSmallCard(String title, String content, String imageUrl, String linkUrl) {
        return createCard(title, content, imageUrl, linkUrl, "small");
    }

    public static DivTag createMediumCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), "medium");
    }

    public static DivTag createMediumCard(String title, String content, String imageUrl, String linkUrl) {
        return createCard(title, content, imageUrl, linkUrl, "medium");
    }

    private static DivTag createCard(String title, String content, String imageUrl, String linkUrl, String cardSize) {
        return div().with(
                div().withClass("col s12 m6 l4").with(
                        a().withHref(linkUrl).with(
                                div().withClass("card hoverable " + cardSize).with(
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
