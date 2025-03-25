package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;
import yi.shi.db.model.Books;

import java.util.List;

import static j2html.TagCreator.*;

public class GeneralCard {

    public static final String CARD_SIZE_LARGE = "large";
    public static final String CARD_SIZE_SMALL = "small";
    public static final String CARD_SIZE_MEDIUM = "medium";

    public static DivTag createCardsDivTag(List<CardData> cardDataList, String cardSize) {
        DivTag[] divTags = new DivTag[cardDataList.size()];
        switch (cardSize) {
            case CARD_SIZE_LARGE:
                cardDataList.forEach(card -> divTags[cardDataList.indexOf(card)] = createLargeCard(card));
                break;
            case CARD_SIZE_SMALL:
                cardDataList.forEach(card -> divTags[cardDataList.indexOf(card)] = createSmallCard(card));
                break;
            case CARD_SIZE_MEDIUM:
                cardDataList.forEach(card -> divTags[cardDataList.indexOf(card)] = createMediumCard(card));
                break;
            default:
                cardDataList.forEach(card -> divTags[cardDataList.indexOf(card)] = createMediumCard(card));
                break;
        }
        return div().with(divTags);
    }

    private static DivTag createLargeCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), CARD_SIZE_LARGE);
    }

    private static DivTag createSmallCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), CARD_SIZE_SMALL);
    }

    private static DivTag createMediumCard(CardData cardData) {
        return createCard(cardData.getTitle(), cardData.getContent(), cardData.getImageUrl(), cardData.getLinkUrl(), CARD_SIZE_MEDIUM);
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
