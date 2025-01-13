package yi.shi.pages.normal;

import j2html.tags.specialized.BodyTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import yi.shi.pages.Page;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class BooksQueryPage extends Page {

    @GET
    @HttpPath(value = "/page/booksQueryPage")
    public HTML booksQueryPage() {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }
    @Override
    protected HeadTag createHead() {
        return Head.createHead("Books");
    }

    @Override
    protected HeaderTag createHeader() {
        return Header.createHeader();
    }

    @Override
    protected BodyTag createBody() {
        return body();
//                .withStyle("  body {\n" +
//                "    display: flex;\n" +
//                "    min-height: 100vh;\n" +
//                "    flex-direction: column;\n" +
//                "  }\n" +
//                "\n" +
//                "  main {\n" +
//                "    flex: 1 0 auto;\n" +
//                "  }");
    }

    @Override
    protected FooterTag createFooter() {
        return Footer.createFooter();
    }
}
