package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;

import java.util.List;

import static j2html.TagCreator.*;

public class GeneralCardContainer {

    public static DivTag createGeneralCardContainer(List<CardData> cardDataList) {
        return div().withClass("row").with(
                div().withId("cardContainer").withClass("container section")
                .with(createGeneralCardList(cardDataList)));
    }

    private static DivTag createGeneralCardList(List<CardData> cardDataList) {
        DivTag[] divTags = new DivTag[cardDataList.size()];
        for (int i = 0; i < cardDataList.size(); i++) {
            divTags[i] = createGeneralCard(cardDataList.get(i));
        }
        return div().with(divTags);
    }

    private static DivTag createGeneralCard(CardData cardData) {
        return div().with(GeneralCard.createLargeCard(cardData));
    }
}
