package yi.shi.pages.element;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.HeadTag;
import yi.shi.pages.resources.JqueryResources;
import yi.shi.pages.resources.MaterializeResources;
import yi.shi.pages.resources.ToastifyResources;

import static j2html.TagCreator.*;

public class Head {

    public static HeadTag createHead(String title) {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title(title),
                link().withRel("stylesheet").withHref(MaterializeResources.MATERIALIZE_MIN_CSS),
                link().withRel("stylesheet").withHref(ToastifyResources.TOASTIFY_CSS),
                script().withSrc(JqueryResources.JQUERY_MIN_JS),
                script().withSrc(MaterializeResources.MATERIALIZE_MIN_JS),
                script().withSrc(ToastifyResources.TOASTIFY_JS)
        );
    }
}
