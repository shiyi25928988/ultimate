package yi.shi.view.pages;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.MainTag;
import yi.shi.db.model.Books;
import yi.shi.view.Page;
import yi.shi.view.component.Head;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.plinth.servlet.ServletHelper;
import yi.shi.service.BooksService;
import yi.shi.service.UserService;

import java.util.Objects;

import static j2html.TagCreator.*;

@HttpService
public class BookDetailPage extends Page {

    private static ThreadLocal<Books> threadLocal = new ThreadLocal<>();

    @Inject
    BooksService booksService;

    @Inject
    UserService userService;

    @GET
    @HttpPath(value = "/page/bookDetailPage")
    public HTML bookDetailPage(@HttpParam("id")String id) throws Exception {
        Books books = booksService.getBooksById(Long.valueOf(id));
        if(Objects.isNull(books)){
            ServletHelper.getResponse().sendRedirect("/page/404");
            return null;
        }else {
            threadLocal.set(books);
        }
        if(StpUtil.isLogin()) {
            super.setThemeColor(userService.getCurrentUser().getThemeColor());
        }
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("Book Detail");
    }

    @Override
    protected MainTag createMain() throws Exception {
        Books books = threadLocal.get();
        return main().withClass("container").with(
                div().withClass("row").with(
                        div().withClass("col s12").with(
                                div().withClass("card").with(
                                        div().withClass("card-image").with(
                                                img().withSrc(books.getCoverUrl()).withClass("responsive-img"),
                                                span(books.getBookName()).withClass("card-title")
                                        ),
                                        div().withClass("card-content").with(
                                                p(books.getDigest())
                                        ),
                                        div().withClass("card-action").with(
                                                a("Read More").withHref("#"),
                                                a("Buy Now").withHref("#")
                                        )
                                )
                        )
                )
        );
    }

}
