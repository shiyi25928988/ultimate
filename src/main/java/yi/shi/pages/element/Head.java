package yi.shi.pages.element;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Head {

    public static ContainerTag createHead() {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title("Your Website Title"),
                link().withRel("stylesheet").withHref("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"),
                link().withRel("stylesheet").withHref("styles.css"), // 引入自定义样式
                script().withSrc("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js").withType("text/javascript")
        );
    }
}
