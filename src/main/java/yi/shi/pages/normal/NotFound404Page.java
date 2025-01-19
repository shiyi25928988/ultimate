package yi.shi.pages.normal;

import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.MainTag;
import yi.shi.pages.Page;
import yi.shi.pages.element.Head;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import static j2html.TagCreator.*;

@HttpService
public class NotFound404Page extends Page {

    @GET
    @HttpPath(value = "/page/404")
    public HTML notFoundPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("Page Not Found");
    }

    @Override
    protected HeaderTag createHeader() throws Exception {
        return null;
    }

    @Override
    protected MainTag createMain() throws Exception {
        return main().with(
            div().withClass("container center-align").with(
                h1().withClass("center-align").withText("404"),
                h5().withClass("center-align").withText("Page Not Found"),
                p().withClass("center-align").withText("The page you are looking for does not exist."),
                a().withHref("/").withClass("btn waves-effect waves-light").withText("Go Home")
            )
        );
    }

    @Override
    protected FooterTag createFooter() throws Exception {
        return null;
    }
}
