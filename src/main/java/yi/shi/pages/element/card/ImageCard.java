package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;

import java.util.List;

import static j2html.TagCreator.*;

public class ImageCard {

    public static DivTag createImageCard(String imageUrl) {
        return div().withClass("col s12 m6 l4").with(
                img().withSrc(imageUrl).withClass("responsive-img materialboxed")
        );
    }

    public static DivTag[] createImageCards(List<String> imageUrls) {
        DivTag[] divTags = new DivTag[imageUrls.size()];
        for (int i = 0; i < imageUrls.size(); i++) {
            divTags[i] = createImageCard(imageUrls.get(i));
        }
        return divTags;
    }
}
