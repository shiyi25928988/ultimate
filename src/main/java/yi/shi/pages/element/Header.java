package yi.shi.pages.element;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Header {
        public static ContainerTag createHeader() {
            return header(
                    nav(
                            div(
                                    a("Logo").withClass("brand-logo").withHref("/"),
                                    ul(
                                            li(a("Home").withClass("nav-link").withHref("/")),
                                            li(a("About").withClass("nav-link").withHref("/about")),
                                            li(a("Contact").withClass("nav-link").withHref("/contact"))
                                    ).withClass("right hide-on-med-and-down")
                            ).withClass("nav-wrapper")
                    ).withClass("navbar blue lighten-2")
            ).withClass("header");
        }


}
