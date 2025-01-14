package yi.shi.pages.normal;

import com.google.inject.Inject;
import j2html.tags.specialized.*;
import org.apache.commons.io.IOUtils;
import yi.shi.pages.Page;
import yi.shi.pages.component.BookCard;
import yi.shi.pages.component.BusyIndicator;
import yi.shi.pages.element.BookSearchHeader;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.BooksService;

import static j2html.TagCreator.*;

@HttpService
public class BooksQueryPage extends Page {

    @Inject
    BooksService booksService;

    @GET
    @HttpPath(value = "/page/booksQueryPage")
    public HTML booksQueryPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }
    @Override
    protected HeadTag createHead() throws Exception{
        return Head.createHead("Books").with(
                script().withSrc(("/js/SearchBooks.js"))
        );
    }

    @Override
    protected HeaderTag createHeader() {
        return BookSearchHeader.createHeader();
    }

    @Override
    protected BodyTag createBody() {
        return body().with(
                BusyIndicator.getBusyIndicator(),
                BookCard.createBookCards(booksService.getAllBooks()));
    }

    @Override
    protected FooterTag createFooter() {
        return Footer.createFooter();
    }

}
