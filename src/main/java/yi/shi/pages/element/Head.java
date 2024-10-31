package yi.shi.pages.element;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Head {

    public static ContainerTag createHead(String title) {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title(title),
                link().withRel("stylesheet").withHref("/css/materialize.min.css"),
                link().withRel("stylesheet").withHref("/css/styles.css"), // 引入自定义样式
                script().withSrc("/js/jquery.min.js"),
                script().withSrc("/js/materialize.min.js")
        );
    }
}
