package yi.shi.pages;

import com.google.inject.Inject;
import j2html.tags.specialized.*;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.pages.element.Head;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.MarkdownFilesService;

import java.util.Objects;

import static j2html.TagCreator.*;

@HttpService
public class ShowMarkdownPage extends Page{

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
    HeadTag createHead() {
        return head(
                    meta().withCharset("UTF-8"),
                    meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                    title(markdownFiles.getTitle()),
                    link().withRel("stylesheet").withHref("/css/typora.css")
                );
    }

    @Override
    HeaderTag createHeader() {
        return null;
    }

    @Override
    BodyTag createBody() {
        return body(
                        div().withClass("container").with(
                                h1(markdownFiles.getTitle()),
                                div().withClass("markdown-content"),
                                rawHtml(markdownFilesService.renderMarkdown(markdownFiles.getContent()))
                        )
                );
    }

    @Override
    FooterTag createFooter() {
        return null;
    }
}
