package yi.shi.pages;

import j2html.tags.Tag;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class ImageWallPage {

    @GET
    @HttpPath(value = "/imageWallPage")
    public HTML imageWallPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(page().render());
        return html;
    }

    private Tag page(){

        return html(Head.createHead(), Header.createHeader(), Footer.createFooter());
    }
}
