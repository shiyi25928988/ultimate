package yi.shi.pages.normal;

import com.google.inject.Inject;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.MainTag;
import yi.shi.db.model.Books;
import yi.shi.pages.Page;
import yi.shi.pages.component.Head;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.plinth.servlet.ServletHelper;

import java.util.Objects;

@HttpService
public class AlbumsPage extends Page {

    @GET
    @HttpPath(value = "/page/albums")
    public HTML albumsPage() throws Exception {

        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("Albums");
    }

    @Override
    protected MainTag createMain() throws Exception {
        return null;
    }
}
