package yi.shi.pages.element;

import static j2html.TagCreator.div;
import static j2html.TagCreator.style;

import j2html.tags.DomContent;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.StyleTag;

public class Container {

    public static DivTag create(DomContent...content) {
        StyleTag inlineStyles = style()
                .withText(
                        ".free-grid { " +
                                "   display: flex; " +
                                "   flex-wrap: wrap; " +
                                "   margin: -16px; " +
                                "} " +
                                ".free-item { " +
                                "   flex: 1 1 calc(33.333% - 32px); " +
                                "   margin: 16px; " +
                                "   box-sizing: border-box; " +
                                "} " +
                                "@media only screen and (max-width: 992px) { " +
                                "   .free-item { " +
                                "       flex: 1 1 calc(50% - 32px); " +
                                "   } " +
                                "} " +
                                "@media only screen and (max-width: 600px) { " +
                                "   .free-item { " +
                                "       flex: 1 1 calc(100% - 32px); " +
                                "   } " +
                                "}"
                );

        DivTag row = div().withClass("free-grid").withStyle("vertical-align: top;");
        for (DomContent item : content) {
            row.with(
                    div().withClass("free-item")
                            .with(item)
            );
        }
        return div().withClass("container section")
                .with(inlineStyles)
                .with(row);
    }

}
