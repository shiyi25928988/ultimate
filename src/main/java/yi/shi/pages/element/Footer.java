package yi.shi.pages.element;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Footer {
    public static ContainerTag createFooter() {
        return footer(
                div(
                        p("Copyright © 2023 Your Company Name. All rights reserved.")
                ).withClass("container center-align")
        ).withClass("page-footer blue lighten-2");
    }
}
