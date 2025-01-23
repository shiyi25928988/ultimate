package yi.shi.pages.component;

import j2html.tags.specialized.ATag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.ImgTag;

import java.util.List;

import static j2html.TagCreator.*;

public class Carousel {

    public static DivTag createCarousel(List<ATag> aTags) {
        ATag[] atags = aTags.toArray(new ATag[0]);
        return div().with(
                div().withClass("carousel carousel-slider center").with(
                    atags
                ),
                script().withSrc("/js/Carousel.js")
        );
    }
}
