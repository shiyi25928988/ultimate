package yi.shi.pages;

import j2html.tags.Tag;
import j2html.tags.specialized.*;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.pages.element.SideBar;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import java.util.HashMap;
import java.util.Map;

import static j2html.TagCreator.*;

@HttpService
public class HomePage extends Page{
    @GET
    @HttpPath(value = "/home")
    public HTML homePage() {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    HeadTag createHead() {
        LinkTag foundationLink = link().withRel("stylesheet").withHref("https://cdn.jsdelivr.net/npm/foundation-sites@6.6.3/dist/css/foundation.min.css");
        return head(foundationLink);
    }

    @Override
    HeaderTag createHeader() {
        return header().withClass("top-bar").withText("My Header");
    }

    @Override
    BodyTag createBody() {
        return body().withClass("row").withText("My Body Content");
    }

    @Override
    FooterTag createFooter() {
        return footer().withClass("footer").withText("My Footer");
    }
}
