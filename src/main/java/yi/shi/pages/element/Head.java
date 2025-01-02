package yi.shi.pages.element;

import j2html.tags.ContainerTag;
import yi.shi.pages.resources.JqueryResources;
import yi.shi.pages.resources.MaterializeResources;

import static j2html.TagCreator.*;

public class Head {

    public static ContainerTag createHead(String title) {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title(title),
                link().withRel("stylesheet").withHref(MaterializeResources.MATERIALIZE_MIN_CSS),
                link().withRel("stylesheet").withHref("/css/toastify.css"),
                link().withRel("stylesheet").withHref("/css/styles.css"), // 引入自定义样式
                script().withSrc(JqueryResources.JQUERY_MIN_JS),
                script().withSrc(MaterializeResources.MATERIALIZE_MIN_JS),
                script().withSrc("/js/toastify.js"),
                script().withSrc("/js/sidebar.js")
        );
    }
}
