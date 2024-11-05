package yi.shi.restapi;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.HTML;
import yi.shi.plinth.http.result.JSON;
import yi.shi.service.MarkdownFilesService;

import java.util.Objects;

@HttpService
public class MarkdownApi {

    @Inject
    MarkdownFilesService markdownFilesService;

    @POST
    @HttpPath("/api/markdown/add")
    public JSON<MarkdownFiles> addNewMarkdown(@HttpBody MarkdownFiles markdownFiles) {
        return new JSON<>(markdownFilesService.addNewMarkdown(markdownFiles));
    }

    @GET
    @HttpPath("/api/markdown/render")
    public HTML renderMarkdown(@HttpParam("id") String id) {
        HTML html = new HTML();
        MarkdownFiles markdownFiles = markdownFilesService.selectById(Long.parseLong(id));
        if(Objects.nonNull(markdownFiles) && !Strings.isNullOrEmpty(markdownFiles.getContent())){
            html.setHtmlContent(markdownFilesService.renderMarkdown(markdownFiles.getContent()));
        }
        return html;
    }
}
