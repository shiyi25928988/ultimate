package yi.shi.pages.normal;

import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.MainTag;
import yi.shi.pages.Page;
import yi.shi.pages.element.Head;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

@HttpService
public class BookDetailPage extends Page {

    @GET
    @HttpPath(value = "/page/bookDetailPage")
    public HTML bookDetailPage(@HttpParam("id")String id) throws Exception {

        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("Book Detail");
    }

    @Override
    protected HeaderTag createHeader() throws Exception {
        return null;
    }

    @Override
    protected MainTag createMain() throws Exception {
        return null;
    }

    @Override
    protected FooterTag createFooter() throws Exception {
        return null;
    }
}
