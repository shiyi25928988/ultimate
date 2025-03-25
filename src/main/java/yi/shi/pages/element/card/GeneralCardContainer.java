package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;

import java.util.List;

import static j2html.TagCreator.*;

public class GeneralCardContainer {

    public static DivTag createLargeCardContainer(List<CardData> cardDataList) {
        return div().withClass("row").with(
                div().withId("cardContainer").withClass("container section")
                .with(GeneralCard.createCardsDivTag(cardDataList, GeneralCard.CARD_SIZE_LARGE)));
    }

    public static DivTag createMediumCardContainer(List<CardData> cardDataList) {
        return div().withClass("row").with(
                div().withId("cardContainer").withClass("container section")
                .with(GeneralCard.createCardsDivTag(cardDataList, GeneralCard.CARD_SIZE_MEDIUM)));
    }

    public static DivTag createSmallCardContainer(List<CardData> cardDataList) {
        return div().withClass("row").with(
                div().withId("cardContainer").withClass("container section")
                .with(GeneralCard.createCardsDivTag(cardDataList, GeneralCard.CARD_SIZE_SMALL)));
    }

}
