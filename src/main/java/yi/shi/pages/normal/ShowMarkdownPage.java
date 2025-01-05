package yi.shi.pages.normal;

import com.google.inject.Inject;
import j2html.tags.specialized.*;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.pages.Page;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.MarkdownFilesService;
import yi.shi.utils.MarkdownUtil;

import java.util.Objects;

import static j2html.TagCreator.*;

@HttpService
public class ShowMarkdownPage extends Page {

    @Inject
    private MarkdownFilesService markdownFilesService;

    private MarkdownFiles markdownFiles;

    @GET
    //@AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/markdown")
    public HTML showMarkdownPage(@HttpParam("id")String id) throws Exception {
        MarkdownFiles markdownFiles = markdownFilesService.selectById(Long.parseLong(id));
        if(Objects.isNull(markdownFiles)){
            throw new Exception("Markdown not found");
        }
        this.markdownFiles = markdownFiles;
        HTML html = new HTML();
        return html.setHtmlContent(createHtml().render());
    }

    @GET
    //@AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/sharedMarkdown")
    public HTML sharedMarkdown(@HttpParam("token")String token) throws Exception {
        MarkdownFiles markdownFiles = markdownFilesService.selectBySharedToken(token);
        if(Objects.isNull(markdownFiles)){
            throw new Exception("Markdown not found");
        }
        this.markdownFiles = markdownFiles;
        HTML html = new HTML();
        return html.setHtmlContent(createHtml().render());
    }



    @Override
    protected HeadTag createHead() {
        return head(
                    meta().withCharset("UTF-8"),
                    meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                    title(markdownFiles.getTitle()),
                    link().withRel("stylesheet").withHref("/css/typora.css")
                );
    }

    @Override
    protected HeaderTag createHeader() {
        return null;
    }

    @Override
    protected BodyTag createBody() {
        String markdownContent = markdownFiles.getContent();
        String toc = MarkdownUtil.generateToc(markdownContent);
        String htmlContent = MarkdownUtil.renderMarkdown(markdownContent);

        return body(
                div().withClass("container").with(
                        div().withClass("md-toc").with(rawHtml(toc)),
                        div().withClass("markdown-content").with(rawHtml(htmlContent))
                )
        );
    }

    @Override
    protected FooterTag createFooter() {
        return null;
    }
}
