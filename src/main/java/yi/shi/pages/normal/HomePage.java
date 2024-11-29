package yi.shi.pages.normal;

import j2html.tags.specialized.*;
import yi.shi.pages.Page;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class HomePage extends Page {
    @GET
    @HttpPath(value = "/home")
    public HTML homePage() {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        LinkTag foundationLink = link().withRel("stylesheet").withHref("https://cdn.jsdelivr.net/npm/foundation-sites@6.6.3/dist/css/foundation.min.css");
        return head(foundationLink);
    }

    @Override
    protected HeaderTag createHeader() {
        return header().withClass("top-bar").withText("My Header");
    }

    @Override
    protected BodyTag createBody() {
        return body().withClass("row").withText("My Body Content");
    }

    @Override
    protected FooterTag createFooter() {
        return footer().withClass("footer").withText("My Footer");
    }
}
