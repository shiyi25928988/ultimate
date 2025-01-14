package yi.shi.pages.component;

import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public class BusyIndicator {

    public static final String BUSY_INDICATOR_ID = "busyIndicator";

    public static DivTag getBusyIndicator() {
        return div().with(div().withClass("preloader-wrapper big active").with(
                div().withClass("spinner-layer spinner-blue").with(
                        div().withClass("circle-clipper left").with(
                                div().withClass("circle")
                        ),
                        div().withClass("gap-patch").with(
                                div().withClass("circle")
                        ),
                        div().withClass("circle-clipper right").with(
                                div().withClass("circle")
                        )
                ),
                div().withClass("spinner-layer spinner-red").with(
                        div().withClass("circle-clipper left").with(
                                div().withClass("circle")
                        ),
                        div().withClass("gap-patch").with(
                                div().withClass("circle")
                        ),
                        div().withClass("circle-clipper right").with(
                                div().withClass("circle")
                        )
                ),
                div().withClass("spinner-layer spinner-yellow").with(
                        div().withClass("circle-clipper left").with(
                                div().withClass("circle")
                        ),
                        div().withClass("gap-patch").with(
                                div().withClass("circle")
                        ),
                        div().withClass("circle-clipper right").with(
                                div().withClass("circle")
                        )
                ),
                div().withClass("spinner-layer spinner-green").with(
                        div().withClass("circle-clipper left").with(
                                div().withClass("circle")
                        ),
                        div().withClass("gap-patch").with(
                                div().withClass("circle")
                        ),
                        div().withClass("circle-clipper right").with(
                                div().withClass("circle")
                        )
                )
        )).withId(BUSY_INDICATOR_ID).withStyle("position: fixed;top: 0;left: 0;width: 100%;height: 100%;display: flex;justify-content: center;align-items: center;background-color: rgba(255, 255, 255, 0.8);z-index: 1000;");//display: none;
    }
}
