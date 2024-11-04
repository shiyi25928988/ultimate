package yi.shi.restapi;

import com.google.inject.Inject;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.service.MarkdownFilesService;

@HttpService
public class MarkdownApi {

    @Inject
    MarkdownFilesService markdownFilesService;

    @POST
    @HttpPath("/api/markdown/add")
    public JSON<MarkdownFiles> addNewMarkdown(@HttpBody MarkdownFiles markdownFiles) {
        return new JSON<>(markdownFilesService.addNewMarkdown(markdownFiles));
    }
}
