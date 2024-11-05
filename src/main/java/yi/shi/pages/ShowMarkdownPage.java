package yi.shi.pages;

import com.google.inject.Inject;
import j2html.tags.specialized.HtmlTag;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.pages.element.Head;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.MarkdownFilesService;

import static j2html.TagCreator.*;

@HttpService
public class ShowMarkdownPage {

    @Inject
    private MarkdownFilesService markdownFilesService;

    @GET
    //@AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/showmarkdown")
    public HTML showMarkdownPage(@HttpParam("id")String id) throws Exception {
        MarkdownFiles markdownFiles = markdownFilesService.selectById(Long.parseLong(id));
        HtmlTag html = html(Head.createHead(markdownFiles.getTitle()),
                body(
                        div().withClass("container").with(
                                h1(markdownFiles.getTitle()),
                                div().withClass("markdown-content"),
                                rawHtml(markdownFilesService.renderMarkdown(markdownFiles.getContent()))
                        )
                )
        );
        HTML page = new HTML();
        page.setHtmlContent(html.renderFormatted());
        return page;
    }
}
