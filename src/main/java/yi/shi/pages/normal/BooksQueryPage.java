package yi.shi.pages.normal;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.specialized.*;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.Page;
import yi.shi.pages.element.card.BookCard;
import yi.shi.pages.component.Footer;
import yi.shi.pages.component.Head;
import yi.shi.pages.component.Header;
import yi.shi.pages.theme.Orange;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.BooksService;
import yi.shi.service.UserService;

import static j2html.TagCreator.*;

@HttpService
public class BooksQueryPage extends Page {

    @Inject
    BooksService booksService;

    @Inject
    UserService userService;

    @GET
    @HttpPath(value = "/page/booksQueryPage")
    public HTML booksQueryPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }
    @Override
    protected HeadTag createHead() throws Exception{
        return Head.createHead("Books");
    }

    @Override
    protected MainTag createMain() throws Exception {
        return main().with(
                div().withClass("container").with(
                    div().withClass("right").with(
                        div().withClass("input-field").with(
                            input().withType("search").withId("search").withPlaceholder("Search books...").attr("aria-label", "Search"),
                            label().withFor("search").with(
                                i().withClass("material-icons").withText("search")
                            ),
                            i().withClass("material-icons").withText("search").attr("onclick", "searchBooks()")
                        ),
                        script().withSrc("/js/SearchBooks.js")
                    )
                ).withClass("row")
        ).with(
            BookCard.createBookCards(booksService.getAllBooks())
        );
    }

    @Override
    protected String getThemeColor() throws Exception {
        if(StpUtil.isLogin()){
            return userService.getCurrentUser().getThemeColor();
        }
        return "";
    }

}
