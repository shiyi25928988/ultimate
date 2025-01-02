package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import org.apache.commons.io.IOUtils;
import yi.shi.pages.resources.JqueryResources;
import yi.shi.pages.resources.MaterializeResources;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import java.nio.charset.StandardCharsets;

import static j2html.TagCreator.*;

@HttpService
public class MarkdownEditorPage {
    @GET
    @AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/markdownEditor")
    public HTML markdownEditor() throws Exception {
        HTML html = new HTML();
        String content = IOUtils.toString(this.getClass().getResourceAsStream("/html/markdown/editor.html"), StandardCharsets.UTF_8);
        html.setHtmlContent(content);
        return html;
    }

    public static ContainerTag createHead() {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title("Markdown Editor"),
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
